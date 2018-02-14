package dk.sdu.mmmi.cbse.common.data;

import dk.sdu.mmmi.cbse.common.data.entityparts.EntityPart;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Entity implements Serializable {

    private final UUID ID = UUID.randomUUID();

    private ArrayList<Float> shapeX;
    private ArrayList<Float> shapeY;
    private float radius;
    private Map<Class, EntityPart> parts;

    public Entity() {
        this.shapeX = new ArrayList<>();
        this.shapeY = new ArrayList<>();
        parts = new ConcurrentHashMap<>();
    }

    public void add(EntityPart part) {
        parts.put(part.getClass(), part);
    }

    public void remove(Class partClass) {
        parts.remove(partClass);
    }

    public <E extends EntityPart> E getPart(Class partClass) {
        return (E) parts.get(partClass);
    }

    public void setRadius(float r) {
        this.radius = r;
    }

    public float getRadius() {
        return radius;
    }

    public String getID() {
        return ID.toString();
    }

    public ArrayList<Float> getShapeX() {
        return shapeX;
    }

    public void setShapeX(ArrayList<Float> shapeX) {
        this.shapeX.clear();
        this.shapeX = shapeX;
    }

    public ArrayList<Float> getShapeY() {
        return shapeY;
    }

    public void setShapeY(ArrayList<Float> shapeY) {
        this.shapeY.clear();
        this.shapeY = shapeY;
    }

}
