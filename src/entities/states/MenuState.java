package entities.states;

import entities.Entity;
import main.Game;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class MenuState extends GameState{

    public MenuState(Game game) {
        super(game);
    }

    @Override
    public void tick() {
        game.changeState(this);
    }

    @Override
    public void render() {
        game.changeState(this);
        BufferStrategy bs = game.getBufferStrategy();
        if (bs == null) {
            game.createBufferStrategy(3);
            return;
        }
        Graphics g = game.image.getGraphics();
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, game.WIDTH, game.HEIGHT);

        g.dispose();
        g = bs.getDrawGraphics();
        g.drawImage(game.image, 0, 0, game.WIDTH * game.SCALE,
                game.HEIGHT * game.SCALE, null);

        bs.show();
    }
}
