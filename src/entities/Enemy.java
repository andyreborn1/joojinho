package entities;

import entities.visitor.CollisionHandler;
import entities.visitor.Visitor;
import main.Controller;
import main.Game;

import java.util.Random;

public class Enemy extends Entity {
    public int life;
    private int frames = 0;
    Random random;
    Visitor visitor;

    public Enemy(String name, double x, double y, double speed,
                 Controller controller, int life,
                 EntitySprites[] entitySprites) {
        super(name, x, y, speed, controller, entitySprites);
        this.life = life;
        random = new Random();
        visitor = new CollisionHandler();

        maxFrames = 5;
    }

    public Enemy(Entity e) {
        super(e);
    }

    public void tick() {
        this.down();

        if (getY() > Game.HEIGHT + 16) {
            x = random.nextInt(Game.WIDTH - 16);
            y = -16;
        }

        runAnimation();

        controller.checkCollision(visitor, this);
    }


    @Override
    public Entity clone() {
        Enemy e = new Enemy(this);
        e.setLife(this.life);
        return e;
    }

    @Override
    public void visit(Visitor visitor, Entity entity) {

    }

    public void setLife(int life) {
        this.life = life;
    }
}
