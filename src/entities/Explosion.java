package entities;

import main.Game;

import java.awt.*;

public class Explosion extends Entity {
    private int frames = 0;
    private int targetFrames = 4;
    private int maxAnimation = 4;
    private int curAnimation = 0;

    public EntitySprites[] explosionSprites = new EntitySprites[5];

    public Explosion(String name, double x, double y, double speed, EntitySprites entitySprites) {
        super(name, x, y, speed, entitySprites);
        explosionSprites[0] = EntityFactory.getSprite("exp0",
                Game.explosion.getSprite(0, 0, 16, 16));
        explosionSprites[1] = EntityFactory.getSprite("exp1",
                Game.explosion.getSprite(16, 0, 16, 16));
        explosionSprites[2] = EntityFactory.getSprite("exp2",
                Game.explosion.getSprite(16 * 2, 0, 16, 16));
        explosionSprites[3] = EntityFactory.getSprite("exp3",
                Game.explosion.getSprite(16 * 3, 0, 16, 16));
        explosionSprites[4] = EntityFactory.getSprite("exp4",
                Game.explosion.getSprite(16 * 4, 0, 16, 16));
        //Game.explosion
        // .getSprite(0, 0,
        // 16, 16);
//        explosionSprites[1] = Game.explosion.getSprite(16, 0, 16, 16);
//        explosionSprites[2] = Game.explosion.getSprite(2 * 16, 0, 16, 16);
//        explosionSprites[3] = Game.explosion.getSprite(3 * 16, 0, 16, 16);
//        explosionSprites[4] = Game.explosion.getSprite(4 * 16, 0, 16, 16);
    }

    public void tick() {
        frames++;

        if (frames == targetFrames) {
            frames = 0;
            curAnimation++;
            if (curAnimation > maxAnimation) {
                Game.entities.remove(this);
            }
        }
    }

    @Override
    public Entity clone() {
        return null;
    }

    public void render(Graphics g) {
        g.drawImage(explosionSprites[curAnimation].sprite, (int) this.getX(),
                (int) this.getY(),
                null);
    }

}
