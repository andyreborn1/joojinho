package main.strategy;

public class Context {
    EnemySpawnStrategy strategy;

    public Context(EnemySpawnStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(EnemySpawnStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute(){
        strategy.execute();
    }
}
