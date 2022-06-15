package entities;


import entities.visitor.Visitor;

import java.awt.*;

public abstract class Entity {
    private final String name;
    protected double x;
    protected double y;
    protected double speed;

    protected int index = 0;
    protected int frames = 0;
    protected int maxFrames;
    protected int maxIndex;

    protected EntitySprites[] entitySprites;


    public Entity(String name, double x, double y, double speed,
                  EntitySprites[] entitySprites) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.entitySprites = entitySprites;

        maxIndex = entitySprites.length - 1;
    }

    public Entity(Entity e) {
        this.name = e.name;
        this.x = e.x;
        this.y = e.y;
        this.speed = e.speed;
        this.entitySprites = e.entitySprites;
    }

    public void render(Graphics graphics) {
        entitySprites[index].render(graphics, x, y);
    }

    public void runAnimation() {
        frames++;

        if (frames == maxFrames) {
            frames = 0;
            index++;

            if (index > maxIndex)
                index = 0;
        }
    }

    public static boolean isColidding(Entity e1, Entity e2) {
        Rectangle e1Mask = new Rectangle((int) e1.getX(), (int) e1.getY(),
                e1.entitySprites[0].sprite.getWidth(),
                e1.entitySprites[0].sprite.getHeight());

        Rectangle e2Mask = new Rectangle((int) e2.getX(), (int) e2.getY(),
                e2.entitySprites[0].sprite.getWidth(),
                e2.entitySprites[0].sprite.getHeight());

        return e1Mask.intersects(e2Mask);
    }

    public abstract void tick();

    public abstract Entity clone();

    public abstract void visit(Visitor visitor, Entity entity);

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

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setEntitySprites(EntitySprites[] entitySprites) {
        this.entitySprites = entitySprites;
    }
}
