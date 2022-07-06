package input;

import entities.states.BuffState;
import entities.states.NormalState;
import input.commands.*;
import main.Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    Game game;
    Command downButton;
    Command upButton;
    Command rightButton;
    Command leftButton;
    Command enterButton;

    public KeyInput(Game game) {
        this.game = game;
        downButton = new DownCommand(game);
        upButton = new UpCommand(game);
        rightButton = new RightCommand(game);
        leftButton = new LeftCommand(game);
        enterButton = new EnterCommand(game);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightButton.execute();
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            leftButton.execute();
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            upButton.execute();
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            downButton.execute();
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
            enterButton.execute();
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE && !game.player.isShooting()) {
            game.player.getState().onShot();
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_C) {
            game.player.changeState(new BuffState(game.player));
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_V) {
            game.player.changeState(new NormalState(game.player));
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
            game.gameState.esc();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            game.gameState.stop();
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            game.gameState.stop();
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
            game.player.setShooting(false);
        }
    }
}
