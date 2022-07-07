package main.strategy;

import entities.Enemy;
import entities.factory.EntityFactory;
import entities.factory.NormalEntityFactory;
import main.Controller;
import main.Game;

import java.util.Random;

public class EnemySpawn1 implements EnemySpawnStrategy {
    private int targetTime = 100;
    private int curTime = 0;
    Controller controller;
    EntityFactory entityFactory;
    Random rand;

    public EnemySpawn1(Controller controller) {
        this.controller = controller;
        entityFactory = new NormalEntityFactory(controller);
        rand = new Random();
    }

    @Override
    public void execute() {
        curTime++;

        if (curTime == targetTime) {
            targetTime = rand.nextInt(150);
            curTime = 0;

            Enemy enemy =
                    entityFactory.createEnemy(rand.nextInt(Game.WIDTH - 16),
                            rand.nextInt(2) + 1);

            controller.addEntity(enemy);
        }
    }
}
