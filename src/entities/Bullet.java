package entities;

import main.Game;

public class Bullet extends Entity {

    public int damage;

    public Bullet(String name, double x, double y, double speed, int damage,
                  EntitySprites entitySprites) {
        super(name, x, y, speed, entitySprites);
        this.damage = damage;
    }

    public void tick() {
        setY(getY() - getSpeed());

        if (this.getY() < -16) {
            Game.entities.remove(this);
        }
    }
}
