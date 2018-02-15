package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;

/**
 *
 * @author Rasmus BG
 */
public class Asteroid extends Entity {
    
    static protected int NUMPOINTS = 5;
    
    static protected int BIG = 0;
    static protected int MEDIUM = 1;
    static protected int SMALL = 2;

    public Asteroid(int numPoint) {
        super(numPoint);
    }

}
