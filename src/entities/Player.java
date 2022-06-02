package entities;

import entities.states.NormalState;
import entities.states.State;
import main.Game;

public class Player extends Entity {

    private State state;

    private boolean right;

    private boolean left;

    public Player(String name, double x, double y, double speed,
                  EntitySprites entitySprites) {
        super(name, x, y, speed, entitySprites);

        this.state = new NormalState(this);
    }

    public void tick() {
        if (getX() > Game.WIDTH - 16) {
            setX(Game.WIDTH - 16);
        }

        if (getX() < 0) {
            setX(0);
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
