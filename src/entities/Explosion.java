package entities;

import entities.visitor.Visitor;
import main.Game;

import java.awt.*;

public class Explosion extends Entity {
    private int frames = 0;
    private int width, height;

    public Explosion(String name, double x, double y, double speed,
                     int width, int height,
                     EntitySprites[] entitySprites) {
        super(name, x, y, speed, entitySprites);
        this.width = width;
        this.height = height;
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
    public void render(Graphics graphics) {
        graphics.drawImage(entitySprites[index].sprite, (int) x, (int) y, width,
                height,
                null);
    }

    @Override
    public Entity clone() {
        return null;
    }

    @Override
    public void visit(Visitor visitor, Entity entity) {
    }
}
