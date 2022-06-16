package entities.factory;

import entities.*;
import graphics.Spritesheet;

public class MediumEntityFactory extends EntityFactory {
    private Spritesheet explosion;
    private Spritesheet enemySprite;

    public MediumEntityFactory() {
        enemySprite = new Spritesheet("/spritesheets/enemy-medium.png");
        explosion = new Spritesheet("/spritesheets/explosion.png");
    }

    @Override
    public Enemy createEnemy(double x, double speed) {
        return new Enemy(
                "mediumEnemy",
                x, -16, speed, 6,
                new EntitySprites[]{
                        EntitySpriteFactory.getSprite("mediumEnemy1",
                                enemySprite.getSprite(0, 0, 32, 16)),
                        EntitySpriteFactory.getSprite("mediumEnemy2",
                                enemySprite.getSprite(32, 0, 32, 16))
                }
        );
    }

    @Override
    public Explosion createExplosion(double x, double y) {
        return new Explosion("explosion", x, y, 0, 32, 32,
                new EntitySprites[]{EntitySpriteFactory.getSprite("exp0",
                        explosion.getSprite(0, 0, 16,
                                16)),
                        EntitySpriteFactory.getSprite("exp1",
                                explosion.getSprite(16,
                                        0, 16, 16)),
                        EntitySpriteFactory.getSprite("exp2",
                                explosion.getSprite(16 * 2, 0, 16, 16)),
                        EntitySpriteFactory.getSprite("exp3",
                                explosion.getSprite(16 * 3, 0, 16, 16)),
                        EntitySpriteFactory.getSprite("exp4",
                                explosion.getSprite(16 * 4, 0, 16, 16))});
    }

    @Override
    public Player createPlayer(double x, double y, double speed, int life) {
        return null;
    }
}
