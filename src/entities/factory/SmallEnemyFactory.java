package entities.factory;

import entities.Enemy;
import entities.Entity;
import entities.EntityFactory;
import entities.EntitySprites;
import main.Game;

public class SmallEnemyFactory extends EnemyFactory {
    @Override
    public Entity createEntity(double x, double y, double speed) {
        return new Enemy(
                "smallEnemy",
                x, -16, speed, 3,
                new EntitySprites[]{
                        EntityFactory.getSprite("smallEnemy1",
                                Game.smallEnemySprite.getSprite(0, 0, 16, 16)),
                        EntityFactory.getSprite("smallEnemy2",
                                Game.smallEnemySprite.getSprite(16, 0, 16, 16))
                }
        );
    }
}