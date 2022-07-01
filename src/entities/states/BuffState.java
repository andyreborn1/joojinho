package entities.states;

import entities.Player;
import entities.builder.BulletBuilder;
import entities.builder.Director;

public class BuffState extends State {
    Director director;

    public BuffState(Player player) {
        super(player);
        director = new Director(new BulletBuilder());
    }

    @Override
    public void onShot() {
        player.changeState(this);
        player.setShooting(true);
        double xx = player.getX() + 5;
        double yy = player.getY();

        director.createPlayerBullet(xx, yy, player.getController());
        player.getController().addEntity(director.getBullet());
    }

}
