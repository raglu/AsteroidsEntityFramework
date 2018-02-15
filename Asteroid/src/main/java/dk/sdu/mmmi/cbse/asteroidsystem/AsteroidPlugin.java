package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.ProjectilePart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import java.util.Random;

public class AsteroidPlugin implements IGamePluginService {

    private Entity asteroid;

    public AsteroidPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {

        // Add entities to the world
        asteroid = createAsteroidObject(gameData);
        world.addEntity(asteroid);
    }

    private Entity createAsteroidObject(GameData gameData) {
        Random random = new Random();

        float x, y;
        float speed = 150;

        if (random.nextBoolean()) {
            x = random.nextFloat() * gameData.getDisplayWidth();
            y = 0;
        } else {
            x = 0;
            y = random.nextFloat() * gameData.getDisplayHeight();
        }
        float radians = random.nextFloat() * 3.1415f * 2;

        Entity AsteroidObject = new Asteroid(Asteroid.NUMPOINTS);
        AsteroidObject.add(new ProjectilePart(speed, radians));
        AsteroidObject.add(new PositionPart(x, y, radians));

        return AsteroidObject;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(asteroid);
    }

}
