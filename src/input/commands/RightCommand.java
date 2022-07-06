package input.commands;

import main.Game;

public class RightCommand extends Command {
    public RightCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        game.gameState.right();
    }
}
