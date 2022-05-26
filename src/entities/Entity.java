package entities;


import java.awt.*;
import java.util.Comparator;

public class Entity {
    private final String name;
    private double x;
    private double y;
    private double speed;
    public int depth;

    private EntitySprites entitySprites;

    public Entity(String name, double x, double y, double speed,
                  EntitySprites entitySprites) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.entitySprites = entitySprites;
    }

    public void render(Graphics graphics) {
        entitySprites.render(name, graphics, (int) this.getX(),
                (int) this.getY());
    }


    public static Comparator<Entity> nodeSorter = new Comparator<Entity>() {

        @Override
        public int compare(Entity n0, Entity n1) {
            if (n1.depth < n0.depth)
                return +1;
            if (n1.depth > n0.depth)
                return -1;
            return 0;
        }

    };

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSpeed() {
        return speed;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void tick() {
    }

    public void left() {
        x += speed;
    }

    public void right() {
        x -= speed;
    }

    public void up() {
        y -= speed;
    }

    public void down() {
        y += speed;
    }
}
