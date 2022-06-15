package entities.visitor;

import entities.*;
import entities.factory.EntityFactory;
import entities.factory.NormalEntityFactory;
import main.Game;

public class CollisionHandler implements Visitor {

    EntityFactory entityFactory;

    @Override
    public void forBullet(Bullet bullet, Enemy enemy) {
        if (Entity.isColidding(enemy, bullet)) {
            Game.entities.remove(bullet);
            enemy.life -= bullet.damage;

            if (enemy.life < 1) {
                entityFactory = new NormalEntityFactory();
                Explosion explosion =
                        entityFactory.createExplosion(enemy.getX(), enemy.getY());

                Game.entities.add(explosion);
                Game.score++;
                Game.entities.remove(enemy);
            }
        }
    }

    @Override
    public void forPlayer(Player player, Enemy enemy) {
        if (Entity.isColidding(enemy, player)) {
            player.setLife(player.getLife() - 1);
            entityFactory = new NormalEntityFactory();
            Explosion explosion = entityFactory.createExplosion(enemy.getX(),
                    enemy.getY());

            Game.entities.add(explosion);
            Game.entities.remove(enemy);
        }
    }
}
