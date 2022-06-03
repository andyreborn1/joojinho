package entities;

import main.Game;

public class Explosion extends Entity {
    private int frames = 0;

    public Explosion(String name, double x, double y, double speed,
                     EntitySprites[] entitySprites) {
        super(name, x, y, speed, entitySprites);
    }

    public void tick() {
        frames++;
        int maxFrames = 4;

        if (frames == maxFrames) {
            frames = 0;
            index++;
            int maxIndex = entitySprites.length - 1;
            if (index > maxIndex)
                Game.entities.remove(this);
        }
    }

    @Override
    public Entity clone() {
        return null;
    }
}
