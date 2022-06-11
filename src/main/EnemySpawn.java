package main;

import entities.Enemy;
import entities.factory.EnemyFactory;
import entities.factory.SmallEnemyFactory;

import java.util.Random;

public class EnemySpawn {
    public int targetTime = 100;
    public int curTime = 0;
    public int time = 0;
    EnemyFactory enemyFactory;

    public void tick() {
        curTime++;
        time++;
        if (curTime == targetTime) {
            Random rand = new Random();
            targetTime = rand.nextInt(150);

            curTime = 0;

            enemyFactory = new SmallEnemyFactory();
            Enemy enemy =
                    (Enemy) enemyFactory.createEntity(
                            rand.nextInt(Game.WIDTH - 16), 0, 1);

            Game.entities.add(enemy);
        }
    }
}
