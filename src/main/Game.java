package main;

import entities.Player;
import entities.factory.EntityFactory;
import entities.factory.NormalEntityFactory;
import entities.states.GameState;
import entities.states.MainMenuState;
import input.KeyInput;
import main.observer.EventListener;
import main.observer.Observer;
import main.observer.Spawn1Observer;
import main.strategy.Context;
import main.strategy.EnemySpawn1;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    public static JFrame frame;
    private Thread thread;
    private boolean isRunning = true;
    public static final int WIDTH = 160;
    public static final int HEIGHT = 240;
    public static final int SCALE = 3;
    public int score = 0;

    private final Controller controller;

    public BufferedImage image;

    public Player player;
    public GameState gameState;
    public Context context;
    public EventListener listener;

    public EntityFactory entityFactory;

    public Game() {
        addKeyListener(new KeyInput(this));
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        initFrame();

        controller = new Controller(this);
        listener = new EventListener();
        Observer observer = new Spawn1Observer(this);
        listener.subscribe(observer);

        gameState = new MainMenuState(this);
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

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

        context = new Context(new EnemySpawn1(controller));
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

