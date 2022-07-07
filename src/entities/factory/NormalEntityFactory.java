package entities.factory;

import entities.*;
import graphics.Spritesheet;
import main.Controller;

public class NormalEntityFactory extends EntityFactory {
    private final Spritesheet playerSprite;
    private final Spritesheet enemySprite;
    private final Spritesheet explosion;
    private final Spritesheet capivara;

    public NormalEntityFactory(Controller controller) {
        super(controller);
        playerSprite = new Spritesheet("/spritesheets/ship.png");
        enemySprite = new Spritesheet("/spritesheets/enemy-small.png");
        explosion = new Spritesheet("/spritesheets/explosion.png");
        capivara = new Spritesheet("/spritesheets/capi-frente.png");
    }

    @Override
    public Enemy createEnemy(double x, double speed) {
        return new Enemy(
                "smallEnemy",
                x, -16, speed, controller, 4,
                new EntitySprites[]{
                        EntitySpriteFactory.getSprite("smallEnemy1",
                                enemySprite.getSprite(0, 0, 16, 16)),
                        EntitySpriteFactory.getSprite("smallEnemy2",
                                enemySprite.getSprite(16, 0, 16, 16))
                }
//                new EntitySprites[]{
//                        EntitySpriteFactory.getSprite("capi1",
//                                capivara.getSprite(0,0,9, 21)),
//                        EntitySpriteFactory.getSprite("capi2",
//                                capivara.getSprite(10,0,9, 21)),
//                        EntitySpriteFactory.getSprite("capi3",
//                                capivara.getSprite(2*10,0,9, 21)),
//                        EntitySpriteFactory.getSprite("capi4",
//                                capivara.getSprite(10*3,0,9, 21)),
//                        EntitySpriteFactory.getSprite("capi5",
//                                capivara.getSprite(10*4,0,9, 21)),
//                }
        );
    }

    @Override
    public Explosion createExplosion(double x, double y) {
        return new Explosion("explosion", x, y, 0, controller, 16, 16,
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
                "Player", x, y, speed, life, controller,
                new EntitySprites[]{
                        EntitySpriteFactory.getSprite("player1",
                                playerSprite.getSprite(16 * 2, 0, 16, 24)),
                        EntitySpriteFactory.getSprite("player2",
                                playerSprite.getSprite(16 * 2, 24, 16, 24))
                }
        );
    }
}
