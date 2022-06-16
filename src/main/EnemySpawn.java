package main;

import entities.Enemy;
import entities.factory.EntityFactory;
import entities.factory.MediumEntityFactory;
import entities.factory.NormalEntityFactory;

import java.util.Random;

public class EnemySpawn {
    public int targetTime = 100;
    public int curTime = 0;
    public int time = 0;
    EntityFactory entityFactory;

    public void tick() {
        curTime++;
        time++;
        if (curTime == targetTime) {
            Random rand = new Random();
            targetTime = rand.nextInt(150);

            curTime = 0;

            entityFactory = new NormalEntityFactory();
            Enemy enemy =
                    entityFactory.createEnemy(rand.nextInt(Game.WIDTH - 16),
                            rand.nextInt(2)+1);
            Game.entities.add(enemy);
        }
    }
}
