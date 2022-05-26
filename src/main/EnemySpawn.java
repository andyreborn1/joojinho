package main;

import entities.Enemy;

import java.util.Random;

public class EnemySpawn {
    public int targetTime = 100;
    public int curTime = 0;
    public int time = 0;

    public void tick() {
        curTime++;
        time++;
        if (curTime == targetTime) {
            Random rand = new Random();
            targetTime = rand.nextInt(150);

            curTime = 0;

            Enemy enemy = new Enemy("small_enemy",
                    rand.nextInt(Game.WIDTH - 16), -16
                    , rand.nextInt(3) + 1,
                    Game.enemyEntitySprite);

            Game.entities.add(enemy);

            if (time % 1000 == 0) {
                Game.entities.add(new Enemy("medium_enemy",
                        rand.nextInt(Game.WIDTH - 32), -16, 1,
                        Game.mediumEnemyEntitySprite));
            }
        }
    }
}
