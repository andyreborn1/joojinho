package entities.chain;

import entities.*;
import main.Game;

public class PlayerCollisionHandler extends CollisionHandler {
    @Override
    public boolean check(Entity e1, Entity e2) {

        if (e1 instanceof Enemy && e2 instanceof Player) {
            Player player = (Player) e2;
            Enemy enemy = (Enemy) e1;

            if (Entity.isColidding(enemy, player)) {
                Game.entities.remove(enemy);

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
            }
        }
        return true;
    }
}
