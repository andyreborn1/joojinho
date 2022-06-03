package main;

import entities.Enemy;
import entities.EntityFactory;
import entities.EntitySprites;

import java.util.Random;

public class EnemySpawn {
    public int targetTime = 100;
    public int curTime = 0;
    public int time = 0;
    Enemy prototype;

    public EnemySpawn() {
        prototype = new Enemy("prototipo",
                10, -16, 1, 2, new EntitySprites[]{});
    }

    public void tick() {
        curTime++;
        time++;
        if (curTime == targetTime) {
            Random rand = new Random();
            targetTime = rand.nextInt(150);

            curTime = 0;

//            Enemy enemy = new Enemy("small_enemy",
//                    rand.nextInt(Game.WIDTH - 16), -16
//                    , rand.nextInt(2) + 1, 3,
//                    Game.enemyEntitySprite);

            Enemy enemy = (Enemy) prototype.clone();
            enemy.setX(rand.nextInt(Game.WIDTH - 16));
            enemy.setSpeed(rand.nextInt(2) + 1);

            enemy.setEntitySprites(new EntitySprites[]{
                    EntityFactory.getSprite("smallEnemy1",
                            Game.smallEnemySprite.getSprite(0, 0, 16, 16)),
                    EntityFactory.getSprite("smallEnemy2",
                            Game.smallEnemySprite.getSprite(16, 0, 16, 16))
            });

            Game.entities.add(enemy);

//            if (time % 100 == 0) {
////                Game.entities.add(new Enemy("medium_enemy",
////                        rand.nextInt(Game.WIDTH - 32), -16, 1, 5,
////                        Game.mediumEnemyEntitySprite));
//
//                Enemy medium = (Enemy) prototype.clone();
//                medium.setX(rand.nextInt(Game.WIDTH - 32));
//                medium.setLife(5);
////                medium.setEntitySprites(Game.mediumEnemyEntitySprite);
//                System.out.println(time);
//                Game.entities.add(medium);
//            }
        }
    }
}
