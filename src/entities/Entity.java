package entities;


import java.awt.*;

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


    public static boolean isColidding(Entity e1, Entity e2) {
        Rectangle e1Mask = new Rectangle((int) e1.getX(), (int) e1.getY(),
                e1.entitySprites.sprite.getWidth(),
                e1.entitySprites.sprite.getHeight());
        Rectangle e2Mask = new Rectangle((int) e2.getX(), (int) e2.getY(),
                e2.entitySprites.sprite.getWidth(),
                e2.entitySprites.sprite.getHeight());

        return e1Mask.intersects(e2Mask);
    }

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
