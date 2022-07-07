package main.strategy;

import entities.Enemy;
import entities.factory.EntityFactory;
import entities.factory.MediumEntityFactory;
import entities.factory.NormalEntityFactory;
import main.Controller;
import main.Game;

import java.util.Random;

public class EnemySpawn3 implements EnemySpawnStrategy {
    private int targetTime = 100;
    private int curTime = 0;
    Controller controller;
    EntityFactory entityFactory;
    Random rand;

    public EnemySpawn3(Controller controller) {
        this.controller = controller;
        rand = new Random();
    }

    @Override
    public void execute() {
        curTime++;

        if (curTime == targetTime) {
            targetTime = rand.nextInt(200);
            curTime = 0;
            Enemy enemy;

            if (rand.nextFloat() < 0.3) {
                entityFactory = new NormalEntityFactory(controller);
                enemy =
                        entityFactory.createEnemy(rand.nextInt(Game.WIDTH - 16), 2);

                controller.addEntity(enemy);
            } else {
                entityFactory = new MediumEntityFactory(controller);
                enemy =
                        entityFactory.createEnemy(rand.nextInt(Game.WIDTH - 32), 1.5);
            }
            controller.addEntity(enemy);
        }
    }
}
