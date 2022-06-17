package entities.states;

import main.Game;

public abstract class GameState {
    Game game;

    public GameState(Game game) {
        this.game = game;
    }

    public abstract void tick();
    public abstract void render();
}
