package entities.states;

import entities.Bullet;
import entities.EntitySpriteFactory;
import entities.EntitySprites;
import entities.Player;
import main.Game;

public class NormalState extends State {
    public NormalState(Player player) {
        super(player);
    }

    @Override
    public void onShot() {
        player.changeState(this);
        player.setShooting(true);
        double xx = player.getX()+5;
        double yy = player.getY();

        EntitySprites normalBullet1 = EntitySpriteFactory.getSprite("normal_bullet1",
                Game.bullets.getSprite(6, 7, 5, 5));
        EntitySprites normalBullet2 = EntitySpriteFactory.getSprite("normal_bullet2",
                Game.bullets.getSprite(20, 7, 5, 5));
        Game.entities.add(new Bullet("bullet", xx, yy, 2, 1,
                new EntitySprites[]{normalBullet1, normalBullet2}));
    }
}
