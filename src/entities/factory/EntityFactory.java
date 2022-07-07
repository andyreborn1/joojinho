package entities.factory;

import entities.Enemy;
import entities.Explosion;
import entities.Player;
import main.Controller;

public abstract class EntityFactory {

    Controller controller;

    protected EntityFactory(Controller controller) {
        this.controller = controller;
    }

    public abstract Enemy createEnemy(double x, double speed);

    public abstract Explosion createExplosion(double x, double y);

    public abstract Player createPlayer(double x, double y, double speed,
                                        int life);
}
