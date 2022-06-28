package entities;

import entities.visitor.Visitor;
import main.Controller;

public class Bullet extends Entity {

    public int damage;
    private int frames = 0;

    public Bullet(String name, double x, double y, double speed,
                  Controller controller, int damage,
                  EntitySprites[] entitySprites) {
        super(name, x, y, speed, controller, entitySprites);
        this.damage = damage;

        maxFrames = 5;
    }

    public void tick() {
        up();

        if (this.getY() < -16) {
            controller.removeEntity(this);
        }
        runAnimation();
    }

    @Override
    public Entity clone() {
        return null;
    }

    @Override
    public void visit(Visitor visitor, Entity entity) {
        visitor.forBullet(this, (Enemy) entity);
    }
}
