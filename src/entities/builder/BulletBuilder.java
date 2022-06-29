package entities.builder;

import entities.Bullet;
import entities.EntitySprites;
import main.Controller;

public class BulletBuilder implements IBulletBuilder {

    private String name;
    private double x;
    private double y;
    private double speed;
    private Controller controller;
    private EntitySprites[] sprites;
    private int damage;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void setSprites(EntitySprites[] sprites) {
        this.sprites = sprites;
    }

    @Override
    public Bullet buildBullet() {
        return new Bullet(name, x, y, speed, controller, damage, sprites);
    }
}
