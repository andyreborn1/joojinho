package entities.states;

import main.Game;

public abstract class GameState {
    Game game;

    public GameState(Game game) {
        this.game = game;
    }

    public abstract void tick();

    public abstract void render();

    public abstract void up();

    public abstract void down();

    public abstract void left();

    public abstract void right();

    public abstract void esc();

    public abstract void enter();

    public abstract void stop();
}
