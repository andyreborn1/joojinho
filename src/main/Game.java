package main;

import entities.Entity;
import entities.EntityFactory;
import entities.EntitySprites;
import entities.Player;
import entities.states.BuffState;
import entities.states.NormalState;
import graphics.Spritesheet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Game extends Canvas implements Runnable, KeyListener {
    private static final long serialVersionUID = 1L;
    public static JFrame frame;
    private Thread thread;
    private boolean isRunning = true;
    public static final int WIDTH = 160;
    public static final int HEIGHT = 240;
    public static final int SCALE = 3;

    private BufferedImage image;

    public static List<Entity> entities;
    public static Spritesheet playerSprite;
    public static Spritesheet smallEnemySprite;
    public static Spritesheet mediumEnemySprite;
    public static Spritesheet bullets;
    public static Spritesheet explosion;
    public static Player player;
    public static EntitySprites mediumEnemyEntitySprite;
    public static EntitySprites enemyEntitySprite;
    public static EntitySprites normalBullet;
    public static EntitySprites buffedBullet;
    public static EntitySprites explosionES;

    EnemySpawn enemySpawn;

    public Game() {
        addKeyListener(this);
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        initFrame();
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        entities = new ArrayList<Entity>();
        playerSprite = new Spritesheet("/spritesheets/ship.png");
        smallEnemySprite = new Spritesheet("/spritesheets/enemy-small.png");
        mediumEnemySprite = new Spritesheet("/spritesheets/enemy-medium.png");
        bullets = new Spritesheet("/spritesheets/laser-bolts.png");
        explosion = new Spritesheet("/spritesheets/explosion.png");


        EntitySprites player1 = EntityFactory.getSprite("player",
                playerSprite.getSprite(16 * 2, 0, 16, 24));
        EntitySprites player2 = EntityFactory.getSprite("player2",
                playerSprite.getSprite(16 * 2, 24, 16, 24));

        enemyEntitySprite = EntityFactory.getSprite(
                "small_enemy", smallEnemySprite.getSprite(0, 0, 16, 16));
        mediumEnemyEntitySprite = EntityFactory.getSprite(
                "medium_enemy", mediumEnemySprite.getSprite(0, 0, 32, 16));

        explosionES = EntityFactory.getSprite("explosion",
                explosion.getSprite(0, 0, 16, 16));

        buffedBullet = EntityFactory.getSprite("buff_bullet",
                bullets.getSprite(0, 12, 12, 20));

        player = new Player("player", Game.WIDTH / 2, Game.HEIGHT - 40, 3,
                new EntitySprites[]{player1, player2});
        enemySpawn = new EnemySpawn();

        entities.add(player);
    }

    public void initFrame() {
        frame = new JFrame("Jogo de Navinha");
        frame.add(this);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public synchronized void start() {
        thread = new Thread(this);
        isRunning = true;
        thread.start();
    }

    public synchronized void stop() {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    public void tick() {
//        enemySpawn.tick();

        for (int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);
            e.tick();
        }
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = image.getGraphics();
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        for (int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);
            e.render(g);
        }

        g.dispose();
        g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);

        bs.show();
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int frames = 0;
        double timer = System.currentTimeMillis();
        requestFocus();

        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                tick();
                render();
                frames++;
                delta--;
            }

            if (System.currentTimeMillis() - timer >= 1000) {
                System.out.println("FPS: " + frames);
                System.out.println("Enitidades: " + entities.size());
                frames = 0;
                timer += 1000;
            }

        }

        stop();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.left();
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            player.right();
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
            player.getState().onShot();
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_C) {
            player.changeState(new BuffState(player));
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_V) {
            player.changeState(new NormalState(player));
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}

