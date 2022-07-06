package input.commands;

import main.Game;

public class LeftCommand extends Command {
    public LeftCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        game.gameState.left();
    }
}
