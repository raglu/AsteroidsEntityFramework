package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;

/**
 *
 * @author Rasmus BG
 */
public class Bullet extends Entity {

    private float x, y, radians;

    private float speed;

    private float lifetimer = 0;
    private final float lifetime = 1;

    public Bullet(float x, float y, float radians) {
        super();
        shapeX = new float[2];
        shapeY = new float[2];

        this.x = x;
        this.y = y;
        this.radians = radians;
    }

    public void updateLifetimer(float time) {
        this.lifetimer += time;
    }

    public boolean shouldRemove() {
        return lifetime <= lifetimer;
    }
}
