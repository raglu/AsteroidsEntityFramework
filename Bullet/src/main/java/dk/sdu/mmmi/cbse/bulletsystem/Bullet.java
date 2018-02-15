package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;

/**
 *
 * @author Rasmus BG
 */
public class Bullet extends Entity {

    static protected int NUMPOINTS = 2;

    private float lifetimer;
    private final float lifetime = 1;

    public Bullet(int numPoint) {
        super(numPoint);
        this.lifetimer = 0;
    }

    public void updateLifetimer(float time) {
        this.lifetimer += time;
    }

    public boolean shouldRemove(){
        return lifetime <= lifetimer; 
    }
}
