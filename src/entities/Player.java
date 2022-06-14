package entities;

import entities.states.NormalState;
import entities.states.State;
import entities.visitor.Visitor;
import main.Game;

public class Player extends Entity {

    private State state;
    private int life;
    private boolean isShooting = false;

    private double velX;

    private int frames = 0;

    public Player(String name, double x, double y, double speed, int life,
                  EntitySprites[] entitySprites) {
        super(name, x, y, speed, entitySprites);
        this.life = life;
        this.state = new NormalState(this);
    }

    public void tick() {
        x += velX;
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
            int maxIndex = entitySprites.length - 1;
            if (index > maxIndex)
                index = 0;
        }
    }

    @Override
    public Entity clone() {
        return null;
    }

    @Override
    public void visit(Visitor visitor, Entity entity) {
        visitor.forPlayer(this, (Enemy) entity);
    }

    public State getState() {
        return state;
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public boolean isShooting() {
        return isShooting;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {
        return life;
    }

    public void setShooting(boolean shooting) {
        isShooting = shooting;
    }
}
