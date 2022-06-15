package entities;

import entities.factory.EntityFactory;
import entities.visitor.CollisionHandler;
import entities.visitor.Visitor;
import main.Game;

import java.util.Random;

public class Enemy extends Entity {
    public int life;
    private int frames = 0;
    Random random;
    EntityFactory entityFactory;
    Visitor visitor;

    public Enemy(String name, double x, double y, double speed, int life,
                 EntitySprites[] entitySprites) {
        super(name, x, y, speed, entitySprites);
        this.life = life;
        random = new Random();
        visitor = new CollisionHandler();

        maxFrames = 7;
    }

    public Enemy(Entity e) {
        super(e);
    }

    public void tick() {
        this.down();
        if (getY() > Game.HEIGHT + 16) {
            x = random.nextInt(Game.WIDTH);
        }

        runAnimation();

        for (int i = 0; i < Game.entities.size(); i++) {
            Entity e = Game.entities.get(i);

            e.visit(visitor, this);
        }
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
