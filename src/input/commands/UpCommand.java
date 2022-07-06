package input.commands;

import main.Game;

public class UpCommand extends Command{
    public UpCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        game.gameState.up();
    }
}
