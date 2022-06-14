package entities;

import entities.visitor.Visitor;
import main.Game;

public class Bullet extends Entity {

    public int damage;
    private int frames = 0;

    public Bullet(String name, double x, double y, double speed, int damage,
                  EntitySprites[] entitySprites) {
        super(name, x, y, speed, entitySprites);
        this.damage = damage;
    }

    public void tick() {
        setY(getY() - getSpeed());

        if (this.getY() < -16) {
            Game.entities.remove(this);
        }

        frames++;
        int maxFrames = 5;

        if (frames == maxFrames) {
            frames = 0;
            index++;
            int maxIndex = 1;
            if (index > maxIndex)
                index = 0;
        }
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
