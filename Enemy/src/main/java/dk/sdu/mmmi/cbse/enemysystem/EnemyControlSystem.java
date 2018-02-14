package dk.sdu.mmmi.cbse.enemysystem;

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
import java.util.Random;

/**
 *
 * @author jcs
 */
public class EnemyControlSystem implements IEntityProcessingService {

    Random random = new Random();

    @Override
    public void process(GameData gameData, World world) {

        for (Entity enemy : world.getEntities(Enemy.class)) {
            PositionPart positionPart = enemy.getPart(PositionPart.class);
            MovingPart movingPart = enemy.getPart(MovingPart.class);

            movingPart.setLeft(random.nextBoolean());
            movingPart.setRight(random.nextBoolean());
            movingPart.setUp(random.nextBoolean());

            movingPart.process(gameData, enemy);
            positionPart.process(gameData, enemy);

            updateShape(enemy);
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
