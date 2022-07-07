package input.commands;

import main.Game;

public abstract class Command {
    Game game;

    protected Command(Game game) {
        this.game = game;
    }

    public abstract void execute();
}
