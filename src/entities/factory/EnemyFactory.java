package entities.factory;

import entities.Entity;

public abstract class EnemyFactory {
    public abstract Entity createEntity(double x, double y, double speed);
}
