package main;

import entities.Entity;
import entities.Player;
import entities.factory.EntityFactory;
import entities.factory.NormalEntityFactory;
import entities.states.GameState;
import entities.states.MainMenuState;
import graphics.Spritesheet;
import input.KeyInput;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Game extends Canvas implements Runnable {

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
        addKeyListener(new KeyInput(this));
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        initFrame();

        controller = new Controller();

        gameState = new MainMenuState(this);
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        entities = new ArrayList<>();

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

    public Controller getController() {
        return controller;
    }
}

