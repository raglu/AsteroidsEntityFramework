package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.ProjectilePart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class BulletPlugin implements IGamePluginService {

    private Entity bullet;

    float x, y, radians;

    public BulletPlugin(float x, float y, float radians) {
        this.x = x;
        this.y = y;
        this.radians = radians;
    }

    @Override
    public void start(GameData gameData, World world) {

        // Add entities to the world
        bullet = createBulletObject(gameData);
        world.addEntity(bullet);
    }

    private Entity createBulletObject(GameData gameData) {

        float speed = 350;

        Entity bulletObject = new Bullet(Bullet.NUMPOINTS);
        bulletObject.add(new ProjectilePart(speed, radians));
        bulletObject.add(new PositionPart(x, y, radians));

        return bulletObject;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(bullet);
    }

}
