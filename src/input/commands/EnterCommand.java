package input.commands;

import main.Game;

public class EnterCommand extends Command {
    public EnterCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        game.gameState.enter();
    }
}
