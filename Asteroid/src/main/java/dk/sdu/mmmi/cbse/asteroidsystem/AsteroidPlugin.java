package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.ProjectilePart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import java.util.Random;

/**
 *
 * @author Rasmus BG
 */
public class AsteroidPlugin implements IGamePluginService {

    private Entity asteroid;
    private Random random = new Random();

    public AsteroidPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {

        // Add entities to the world
        asteroid = createAsteroidobject(gameData);
        world.addEntity(asteroid);
    }

    private Entity createAsteroidobject(GameData gameData) {

        float x, y;
        float speed = 200;

        if (random.nextBoolean()) {
            x = random.nextFloat() * gameData.getDisplayWidth();
            y = 0;
        } else {
            x = 0;
            y = random.nextFloat() * gameData.getDisplayHeight();
        }
        float radians = random.nextFloat() * 2 * 3.1415f;

        Entity asteroidObject = new Asteroid();
        asteroidObject.add(new ProjectilePart(speed, radians));
        asteroidObject.add(new PositionPart(x, y, radians));

        return asteroidObject;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(asteroid);
    }
}
