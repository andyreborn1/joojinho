package entities.states;

import graphics.menu.GameMenu;
import graphics.menu.MainMenu;
import main.Game;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class MainMenuState extends GameState {

    GameMenu menu;

    public MainMenuState(Game game) {
        super(game);
        menu = new MainMenu();
    }

    @Override
    public void tick() {
        menu.tick();
    }

    @Override
    public void render() {
        BufferStrategy bs = game.getBufferStrategy();
        if (bs == null) {
            game.createBufferStrategy(3);
            return;
        }
        Graphics g = game.image.getGraphics();

        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, game.WIDTH, game.HEIGHT);

        g = bs.getDrawGraphics();
        g.drawImage(game.image, 0, 0, game.WIDTH * game.SCALE,
                game.HEIGHT * game.SCALE, null);

        menu.render(g);

        g.dispose();
        bs.show();
    }

    @Override
    public void up() {
        menu.up = true;
    }

    @Override
    public void down() {
        menu.down = true;
    }

    @Override
    public void left() {

    }

    @Override
    public void right() {

    }

    @Override
    public void esc() {

    }

    @Override
    public void enter() {
        if (menu.currentOption == 0) {
            game.newGame();
            game.changeState(new InGameState(game));
        } else if (menu.currentOption == 1) {

        } else if (menu.currentOption == 2) {
            System.exit(1);
        }
    }

    @Override
    public void stop() {

    }
}
