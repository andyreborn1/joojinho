package entities.visitor;

import entities.Bullet;
import entities.Enemy;
import entities.Player;

public interface Visitor {
    void forBullet(Bullet bullet, Enemy enemy);
    void forPlayer(Player player, Enemy enemy);
}
