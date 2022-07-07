package main.observer;

import main.Game;
import main.strategy.EnemySpawn2;
import main.strategy.EnemySpawn3;

public class Spawn1Observer implements Observer {

    Game game;
    int enemyCount = 100;

    public Spawn1Observer(Game game) {
        this.game = game;
    }

    @Override
    public void update(int score) {
        if (score >= 200 && score >= enemyCount) {
            game.context.setStrategy(new EnemySpawn2(game.getController()));
            enemyCount += 200;
        } else if (score >= 400 && score >= enemyCount) {
            game.context.setStrategy(new EnemySpawn3(game.getController()));
            game.listener.unsubscribe(this);
        }
    }
}
