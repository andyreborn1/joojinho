package entities.states;

import entities.Player;
import main.Game;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class InGameState extends GameState {

    Player player;

    public InGameState(Game game) {
        super(game);
        player = game.player;
    }

    @Override
    public void tick() {
        game.changeState(this);

        game.getController().tick();

        game.context.execute();

        if (player.getLife() < 1) {
            game.changeState(new MainMenuState(game));
        }

        game.listener.getScore(game.score);
    }

    @Override
    public void render() {
        int gs = Game.SCALE;

        game.changeState(this);
        BufferStrategy bs = game.getBufferStrategy();
        if (bs == null) {
            game.createBufferStrategy(3);
            return;
        }
        Graphics g = game.image.getGraphics();
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);


        game.getController().render(g);

        g = bs.getDrawGraphics();
        g.drawImage(game.image, 0, 0, Game.WIDTH * Game.SCALE,
                Game.HEIGHT * Game.SCALE, null);

        g.setColor(Color.GRAY);
        g.fillRect(5 * gs, 5 * gs, 50 * gs, 10 * gs);

        g.setColor(Color.GREEN);
        g.fillRect(5 * gs, 5 * gs, player.getLife() * 5 * gs, 10 * gs);

        g.setColor(Color.WHITE);
        g.drawRect(5 * gs, 5 * gs, 50 * gs, 10 * gs);


        Font font = new Font("TimesRoman", Font.PLAIN, 15);
        g.setFont(font);
        g.drawString(String.format("Score: %d", game.score), 5 * gs, 25 * gs);

        g.dispose();
        bs.show();
    }

    public void drawCenteredString(String s, int w, int h, Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        int x = (w - fm.stringWidth(s)) / 2;
        int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
        g.drawString(s, x, y);
    }

    @Override
    public void up() {

    }

    @Override
    public void down() {

    }

    @Override
    public void left() {
        player.setVelX(-player.getSpeed());
    }

    @Override
    public void right() {
        player.setVelX(player.getSpeed());
    }


    @Override
    public void esc() {
        game.changeState(new PauseMenuState(game));
    }

    @Override
    public void enter() {

    }

    @Override
    public void stop() {
        player.setVelX(0);
    }
}
