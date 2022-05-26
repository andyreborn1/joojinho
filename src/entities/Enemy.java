package entities;

import main.Game;

public class Enemy extends Entity {
    public Enemy(String name, double x, double y, double speed,
                 EntitySprites entitySprites) {
        super(name, x, y, speed, entitySprites);
    }

    public void tick() {
        this.down();
        if (getY() > Game.HEIGHT + 16) {
            Game.entities.remove(this);
        }
    }
}
