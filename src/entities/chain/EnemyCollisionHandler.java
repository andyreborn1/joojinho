package entities.chain;

import entities.*;
import main.Game;

public class EnemyCollisionHandler extends CollisionHandler {
    @Override
    public boolean check(Entity e1, Entity e2) {
        if (e1 instanceof Enemy && e2 instanceof Bullet) {
            Enemy enemy = (Enemy) e1;
            Bullet bullet = (Bullet) e2;

            if (Entity.isColidding(enemy, bullet)) {
                Game.entities.remove(bullet);
                enemy.life -= bullet.damage;

                if (enemy.life < 1) {
                    Explosion explosion = new Explosion("explosion",
                            enemy.getX(), enemy.getY(), 0,
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
                    Game.entities.remove(enemy);
                }
            }
            return true;
        }
        return checkNext(e1, e2);
    }
}
