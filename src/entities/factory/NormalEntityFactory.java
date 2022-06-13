package entities.factory;

import entities.*;
import graphics.Spritesheet;

public class NormalEntityFactory extends EntityFactory {
    private final Spritesheet playerSprite;
    private final Spritesheet enemySprite;
    private final Spritesheet explosion;

    public NormalEntityFactory() {
        playerSprite = new Spritesheet("/spritesheets/ship.png");
        enemySprite = new Spritesheet("/spritesheets/enemy-small.png");
        explosion = new Spritesheet("/spritesheets/explosion.png");
    }

    @Override
    public Enemy createEnemy(double x, double speed) {
        return new Enemy(
                "smallEnemy",
                x, -16, speed, 3,
                new EntitySprites[]{
                        EntitySpriteFactory.getSprite("smallEnemy1",
                                enemySprite.getSprite(0, 0, 16, 16)),
                        EntitySpriteFactory.getSprite("smallEnemy2",
                                enemySprite.getSprite(16, 0, 16, 16))
                }
        );
    }

    @Override
    public Explosion createExplosion(double x, double y) {
        return new Explosion("explosion", x, y, 0, 16, 16,
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
        return new Player(
                "Player", x, y, speed, life,
                new EntitySprites[]{
                        EntitySpriteFactory.getSprite("player1",
                                playerSprite.getSprite(16 * 2, 0, 16, 24)),
                        EntitySpriteFactory.getSprite("player2",
                                playerSprite.getSprite(16 * 2, 24, 16, 24))
                }
        );
    }
}
