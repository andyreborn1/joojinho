package entities.factory;

import entities.Enemy;
import entities.Explosion;
import entities.Player;

public abstract class EntityFactory {
    public abstract Enemy createEnemy(double x, double speed);

    public abstract Explosion createExplosion(double x, double y);

    public abstract Player createPlayer(double x, double y, double speed,
                                     int life);
}
