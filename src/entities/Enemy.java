package entities;

import entities.factory.EntityFactory;
import entities.factory.NormalEntityFactory;
import main.Game;

import java.util.Random;

public class Enemy extends Entity {
    public int life;
    private int frames = 0;
    Random random;
    EntityFactory entityFactory;

    public Enemy(String name, double x, double y, double speed, int life,
                 EntitySprites[] entitySprites) {
        super(name, x, y, speed, entitySprites);
        this.life = life;
        random = new Random();
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

            if (e instanceof Bullet) {
                if (Entity.isColidding(this, e)) {
                    Game.entities.remove(e);
                    life -= ((Bullet) e).damage;

                    if (this.life < 1) {
                        entityFactory = new NormalEntityFactory();
                        Explosion explosion = entityFactory.createExplosion(x, y);

                        Game.entities.add(explosion);
                        Game.score++;
                        Game.entities.remove(this);
                    }
                }
            } else if (e instanceof Player) {
                if (Entity.isColidding(this, e)) {
                    ((Player) e).setLife(((Player) e).getLife() - 1);
                    entityFactory = new NormalEntityFactory();
                    Explosion explosion = entityFactory.createExplosion(x, y);

                    Game.entities.add(explosion);
                    Game.entities.remove(this);
                }
            }
//        }
        }
    }


    @Override
    public Entity clone() {
        Enemy e = new Enemy(this);
        e.setLife(this.life);
        return e;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
