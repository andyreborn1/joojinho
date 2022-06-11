package entities.factory;

import entities.Enemy;
import entities.Entity;
import entities.EntityFactory;
import entities.EntitySprites;
import main.Game;

public class MediumEnemyFactory extends EnemyFactory {
    @Override
    public Entity createEntity(double x, double y, double speed) {
        return new Enemy(
                "mediumEnemy",
                x, -16, speed, 6,
                new EntitySprites[]{
                        EntityFactory.getSprite("mediumEnemy1",
                                Game.mediumEnemySprite.getSprite(0, 0, 32, 16)),
                        EntityFactory.getSprite("mediumEnemy2",
                                Game.mediumEnemySprite.getSprite(32, 0, 32, 16))
                }
        );
    }
}
