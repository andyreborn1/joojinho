package entities;

import entities.visitor.Visitor;
import main.Controller;

import java.awt.*;

public class Explosion extends Entity {
    private int width, height;

    public Explosion(String name, double x, double y, double speed,
                     Controller controller,
                     int width, int height,
                     EntitySprites[] entitySprites) {
        super(name, x, y, speed, controller, entitySprites);
        this.width = width;
        this.height = height;

        maxFrames = 4;
    }

    public void tick() {
        runAnimation();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(entitySprites[index].sprite, (int) x, (int) y, width,
                height,
                null);
    }

    @Override
    public void runAnimation() {
        frames++;

        if (frames == maxFrames) {
            frames = 0;
            index++;

            if (index > maxIndex)
                controller.removeEntity(this);
        }
    }

    @Override
    public Entity clone() {
        return this;
    }

    @Override
    public void visit(Visitor visitor, Entity entity) {
        // TODO não vai usar se pa
    }
}
