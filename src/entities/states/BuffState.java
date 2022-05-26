package entities.states;

import entities.Bullet;
import entities.Player;
import main.Game;

public class BuffState extends State {

    public BuffState(Player player) {
        super(player);
    }

    @Override
    public void onShot() {
        player.changeState(this);
        double xx = player.getX();
        double yy = player.getY() - 10;

        Game.entities.add(new Bullet("buff_bullet", xx, yy, 2,
                Game.buffedBullet));
    }

}
