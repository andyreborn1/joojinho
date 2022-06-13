package entities.states;

import entities.Bullet;
import entities.EntitySpriteFactory;
import entities.EntitySprites;
import entities.Player;
import main.Game;

public class BuffState extends State {

    public BuffState(Player player) {
        super(player);
    }

    @Override
    public void onShot() {
        player.changeState(this);
        player.setShooting(true);
        double xx = player.getX()+5;
        double yy = player.getY();

        EntitySprites buffedBullet1 = EntitySpriteFactory.getSprite("buffed_bullet1",
                Game.bullets.getSprite(6, 18, 5, 12));
        EntitySprites buffedBullet2 = EntitySpriteFactory.getSprite("buffed_bullet2",
                Game.bullets.getSprite(20, 18, 5, 12));
        Game.entities.add(new Bullet("bullet", xx, yy, 2, 5,
                new EntitySprites[]{buffedBullet1, buffedBullet2}));
    }

}
