package input;

import entities.states.BuffState;
import entities.states.NormalState;
import main.Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    Game game;

    public KeyInput(Game game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            game.gameState.right();
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            game.gameState.left();
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            game.gameState.up();
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            game.gameState.down();
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
            game.gameState.enter();
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE && !Game.player.isShooting()) {
            Game.player.getState().onShot();
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_C) {
            Game.player.changeState(new BuffState(Game.player));
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_V) {
            Game.player.changeState(new NormalState(Game.player));
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
            game.gameState.esc();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            Game.player.setVelX(0);
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            Game.player.setVelX(0);
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
            Game.player.setShooting(false);
        }
    }
}
