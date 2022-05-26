package entities;

import entities.states.NormalState;
import entities.states.State;
import main.Game;

public class Player extends Entity {

    private State state;

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

    public void shot() {
        double xx = this.getX();
        double yy = this.getY() - 10;

        Game.entities.add(new Bullet("bullet", xx, yy, 2,
                Game.normalBullet));
    }

    public void buffShot() {
        double xx = this.getX();
        double yy = this.getY() - 10;

        Game.entities.add(new Bullet("buff_bullet", xx, yy, 2,
                Game.buffedBullet));
    }

    public State getState() {
        return state;
    }

    public void changeState(State state) {
        this.state = state;
    }
}
