package entities.states;

import entities.Bullet;
import entities.Player;
import main.Game;

public class NormalState extends State {
    public NormalState(Player player) {
        super(player);
    }

    @Override
    public void onShot() {
        player.changeState(this);
        double xx = player.getX();
        double yy = player.getY() - 10;

        Game.entities.add(new Bullet("bullet", xx, yy, 2,
                Game.normalBullet));
    }
}
