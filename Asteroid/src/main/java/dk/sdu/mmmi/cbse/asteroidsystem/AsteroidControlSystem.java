package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.ProjectilePart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import java.util.ArrayList;

/**
 *
 * @author jcs
 */
public class AsteroidControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            PositionPart positionPart = asteroid.getPart(PositionPart.class);
            ProjectilePart movingPart = asteroid.getPart(ProjectilePart.class);

            movingPart.process(gameData, asteroid);
            positionPart.process(gameData, asteroid);

            updateShape(asteroid);
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
        shapey.add(0, (float) (x + Math.sin(radians) * 8));
        
        shapex.add(1, (float) (x + Math.cos(radians + 2 * 3.1415f / 5) * 8));
        shapey.add(1, (float) (x + Math.sin(radians + 2 * 3.1415f / 5) * 8));
        
        shapex.add(2, (float) (x + Math.cos(radians + 4 * 3.1415f / 5) * 8));
        shapey.add(2, (float) (x + Math.sin(radians + 4 * 3.1415f / 5) * 8));
        
        shapex.add(3, (float) (x + Math.cos(radians + 6 * 3.1415f / 5) * 8));
        shapey.add(3, (float) (x + Math.sin(radians + 6 * 3.1415f / 5) * 8));
        
        shapex.add(4, (float) (x + Math.cos(radians + 8 * 3.1415f / 5) * 8));
        shapey.add(4, (float) (x + Math.sin(radians + 8 * 3.1415f / 5) * 8));

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }

}
