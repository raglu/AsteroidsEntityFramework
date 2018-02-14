package dk.sdu.mmmi.cbse.playersystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import static dk.sdu.mmmi.cbse.common.data.GameKeys.LEFT;
import static dk.sdu.mmmi.cbse.common.data.GameKeys.RIGHT;
import static dk.sdu.mmmi.cbse.common.data.GameKeys.UP;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import java.util.ArrayList;

/**
 *
 * @author jcs
 */
public class PlayerControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity player : world.getEntities(Player.class)) {
            PositionPart positionPart = player.getPart(PositionPart.class);
            MovingPart movingPart = player.getPart(MovingPart.class);

            movingPart.setLeft(gameData.getKeys().isDown(LEFT));
            movingPart.setRight(gameData.getKeys().isDown(RIGHT));
            movingPart.setUp(gameData.getKeys().isDown(UP));

            movingPart.process(gameData, player);
            positionPart.process(gameData, player);

            updateShape(player);
        }
    }

    private void updateShape(Entity entity) {
        ArrayList<Float> shapex = new ArrayList<>();
        ArrayList<Float> shapey = new ArrayList<>();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex.add(0, (float) (x + Math.cos(radians) * 8));
        shapey.add(0, (float) (y + Math.sin(radians) * 8));

        shapex.add(1, (float) (x + Math.cos(radians - 4 * 3.1415f / 5) * 8));
        shapey.add(1, (float) (y + Math.sin(radians - 4 * 3.1415f / 5) * 8));

        shapex.add(2, (float) (x + Math.cos(radians + 3.1415f) * 5));
        shapey.add(2, (float) (y + Math.sin(radians + 3.1415f) * 5));

        shapex.add(3, (float) (x + Math.cos(radians + 4 * 3.1415f / 5) * 8));
        shapey.add(3, (float) (y + Math.sin(radians + 4 * 3.1415f / 5) * 8));

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }

}
