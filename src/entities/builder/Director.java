package entities.builder;

import entities.Bullet;
import entities.EntitySpriteFactory;
import entities.EntitySprites;
import graphics.Spritesheet;
import main.Controller;

public class Director {
    private final Spritesheet bullets;
    private IBulletBuilder builder;

    public Director(IBulletBuilder builder) {
        this.builder = builder;
        bullets = new Spritesheet("/spritesheets/laser-bolts.png");
    }

    public void createPlayerBullet(double x, double y, Controller controller) {
        builder.setName("bullet");
        builder.setX(x);
        builder.setY(y);
        builder.setSpeed(2);
        builder.setController(controller);
        builder.setDamage(2);
        builder.setSprites(
                new EntitySprites[]{
                        EntitySpriteFactory.getSprite("buffed_bullet1",
                                bullets.getSprite(6, 18, 5, 12)),
                        EntitySpriteFactory.getSprite("buffed_bullet2",
                                bullets.getSprite(20, 18, 5, 12))
                }
        );
    }

    public void createEnemyBullet(double x, double y, Controller controller) {
        builder.setName("bullet");
        builder.setX(x);
        builder.setY(y);
        builder.setSpeed(0.5);
        builder.setController(controller);
        builder.setDamage(1);
        builder.setSprites(
                new EntitySprites[]{
                        EntitySpriteFactory.getSprite("normal_bullet1",
                                bullets.getSprite(6, 7, 5, 5)),
                        EntitySpriteFactory.getSprite("normal_bullet2",
                                bullets.getSprite(20, 7, 5, 5))
                }
        );
    }

    public Bullet getBullet() {
        return builder.buildBullet();
    }
}
