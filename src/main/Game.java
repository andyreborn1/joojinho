package main;

import entities.Entity;
import entities.Player;
import entities.factory.EntityFactory;
import entities.factory.NormalEntityFactory;
import entities.states.BuffState;
import entities.states.GameState;
import entities.states.MenuState;
import entities.states.NormalState;
import graphics.Spritesheet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    public static int score = 0;

    private final Controller controller;

    public BufferedImage image;

    public static List<Entity> entities;
    public static Spritesheet bullets;
    public static Player player;
    public GameState gameState;

    public EntityFactory entityFactory;

    public EnemySpawn enemySpawn;

    public Game() {
        addKeyListener(this);
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        initFrame();

        controller = new Controller();

        gameState = new MenuState(this);
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        entities = new ArrayList<>();

        bullets = new Spritesheet("/spritesheets/laser-bolts.png");

        entityFactory = new NormalEntityFactory(controller);
        player = entityFactory.createPlayer(Game.WIDTH / 2, Game.HEIGHT - 40,
                1, 10);
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

    public void newGame() {
        controller.clear();
        player = entityFactory.createPlayer(Game.WIDTH / 2, Game.HEIGHT - 40,
                1, 10);
        enemySpawn = new EnemySpawn(controller);
        controller.addEntity(player);
        score = 0;
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

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        double timer = System.currentTimeMillis();
        requestFocus();

        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                gameState.tick();
                updates++;
                delta--;
            }

            gameState.render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(updates + " Ticks, FPS: " + frames);
                frames = 0;
                updates = 0;
            }

        }

        stop();
    }

    public void changeState(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            gameState.right();
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            gameState.left();
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            gameState.up();
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            gameState.down();
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
            gameState.enter();
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE && !player.isShooting()) {
            player.getState().onShot();
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_C) {
            player.changeState(new BuffState(player));
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_V) {
            player.changeState(new NormalState(player));
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
            gameState.esc();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.setVelX(0);
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            player.setVelX(0);
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
            player.setShooting(false);
        }
    }

    public Controller getController() {
        return controller;
    }
}

