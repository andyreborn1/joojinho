package input.commands;

import main.Game;

public class DownCommand extends Command {

    public DownCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        game.gameState.down();
    }
}
