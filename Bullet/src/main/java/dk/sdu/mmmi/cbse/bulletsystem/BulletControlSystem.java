package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.ProjectilePart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

/**
 *
 * @author jcs
 */
public class BulletControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity entity : world.getEntities(Bullet.class)) {

            Bullet bullet = (Bullet) entity;

            bullet.updateLifetimer(gameData.getDelta());
            if (bullet.shouldRemove()) {
                world.removeEntity(entity);
            }

            PositionPart positionPart = bullet.getPart(PositionPart.class);
            ProjectilePart movingPart = bullet.getPart(ProjectilePart.class);

            movingPart.process(gameData, bullet);
            positionPart.process(gameData, bullet);

            updateShape(bullet);
        }
    }

    private void updateShape(Entity entity) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians) * 1);
        shapey[0] = (float) (y + Math.sin(radians) * 1);

        shapex[1] = (float) (x - Math.cos(radians) * 1);
        shapey[1] = (float) (y - Math.sin(radians) * 1);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }

}
