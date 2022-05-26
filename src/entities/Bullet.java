package entities;

import main.Game;

public class Bullet extends Entity {
    public Bullet(String name, double x, double y, double speed,
                  EntitySprites entitySprites) {
        super(name, x, y, speed, entitySprites);
    }

    public void tick() {
        setY(getY() - getSpeed());

        if (this.getY() < -16) {
            Game.entities.remove(this);
        }
    }
}
