package entities;

import main.Game;

public class Enemy extends Entity {
    public int life;
    private int frames = 0;

    public Enemy(String name, double x, double y, double speed, int life,
                 EntitySprites[] entitySprites) {
        super(name, x, y, speed, entitySprites);
        this.life = life;
    }

    public Enemy(Entity e) {
        super(e);
    }

    public void tick() {
        this.down();
        if (getY() > Game.HEIGHT + 16) {
            Game.entities.remove(this);
        }

        frames++;
        int maxFrames = 7;

        if (frames == maxFrames) {
            frames = 0;
            index++;
            int maxIndex = entitySprites.length-1;
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
                        Explosion explosion = new Explosion("explosion",
                                x, y, 0,
                                new EntitySprites[]{EntityFactory.getSprite("exp0",
                                        Game.explosion.getSprite(0, 0, 16,
                                                16)),
                                        EntityFactory.getSprite("exp1",
                                                Game.explosion.getSprite(16,
                                                        0, 16, 16)),
                                        EntityFactory.getSprite("exp2",
                                                Game.explosion.getSprite(16 * 2, 0, 16, 16)),
                                        EntityFactory.getSprite("exp3",
                                                Game.explosion.getSprite(16 * 3, 0, 16, 16)),
                                        EntityFactory.getSprite("exp4",
                                                Game.explosion.getSprite(16 * 4, 0, 16, 16))});

                        Game.entities.add(explosion);
                        Game.entities.remove(this);
                    }
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
