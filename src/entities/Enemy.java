package entities;

import entities.factory.EntityFactory;
import entities.factory.NormalEntityFactory;
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
    }

    public Enemy(Entity e) {
        super(e);
    }

    public void tick() {
        this.down();
        if (getY() > Game.HEIGHT + 16) {
//            Game.entities.remove(this);
            x = random.nextInt(Game.WIDTH);
        }

        frames++;
        int maxFrames = 7;

        if (frames == maxFrames) {
            frames = 0;
            index++;
            int maxIndex = entitySprites.length - 1;
            if (index > maxIndex)
                index = 0;
        }

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
