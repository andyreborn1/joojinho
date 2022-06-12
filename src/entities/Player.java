package entities;

import entities.states.NormalState;
import entities.states.State;
import main.Game;

public class Player extends Entity {

    private State state;
    private int life;

    private boolean right;
    private boolean left;

    private int frames = 0;

    public Player(String name, double x, double y, double speed, int life,
                  EntitySprites[] entitySprites) {
        super(name, x, y, speed, entitySprites);
        this.life = life;
        this.state = new NormalState(this);
    }

    public void tick() {
        if (getX() > Game.WIDTH - 16) {
            setX(Game.WIDTH - 16);
        }

        if (getX() < 0) {
            setX(0);
        }

        frames++;
        int maxFrames = 7;

        if (frames == maxFrames) {
            frames = 0;
            index++;
            int maxIndex = entitySprites.length-1;
            if (index > maxIndex)
                index = 0;
        }
    }

    @Override
    public Entity clone() {
        return null;
    }

    public State getState() {
        return state;
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }
}
