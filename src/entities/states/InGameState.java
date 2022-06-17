package entities.states;

import entities.Entity;
import main.Game;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class InGameState extends GameState {

    public InGameState(Game game) {
        super(game);
    }

    @Override
    public void tick() {
        game.changeState(this);
        game.enemySpawn.tick();

        for (int i = 0; i < game.entities.size(); i++) {
            Entity e = game.entities.get(i);
            e.tick();
        }
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

        for (int i = 0; i < game.entities.size(); i++) {
            Entity e = game.entities.get(i);
            e.render(g);
        }

        g.dispose();
        g = bs.getDrawGraphics();
        g.drawImage(game.image, 0, 0, game.WIDTH * game.SCALE,
                game.HEIGHT * game.SCALE, null);

        bs.show();
    }
}
