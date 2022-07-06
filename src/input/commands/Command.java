package input.commands;

import main.Game;

public abstract class Command {
    Game game;

    public Command(Game game) {
        this.game = game;
    }

    public abstract void execute();
}
