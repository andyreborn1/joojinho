package entities.visitor;

import entities.*;
import entities.factory.EntityFactory;
import entities.factory.NormalEntityFactory;
import main.Controller;

public class CollisionHandler implements Visitor {

    EntityFactory entityFactory;
    Controller controller;

    @Override
    public void forBullet(Bullet bullet, Enemy enemy) {
        controller = bullet.getController();

        if (Entity.isColidding(enemy, bullet)) {
            controller.removeEntity(bullet);
            enemy.life -= bullet.damage;

            if (enemy.life < 1) {
                entityFactory = new NormalEntityFactory(controller);
                Explosion explosion =
                        entityFactory.createExplosion(enemy.getX(), enemy.getY());

                controller.addEntity(explosion);
                controller.game.score = controller.game.score + enemy.getPoints();
                controller.removeEntity(enemy);
            }
        }
    }

    @Override
    public void forPlayer(Player player, Enemy enemy) {
        controller = player.getController();

        if (Entity.isColidding(enemy, player)) {
            player.setLife(player.getLife() - enemy.getDamage());
            entityFactory = new NormalEntityFactory(controller);
            Explosion explosion = entityFactory.createExplosion(enemy.getX(),
                    enemy.getY());

            controller.addEntity(explosion);
            controller.removeEntity(enemy);
        }
    }
}
