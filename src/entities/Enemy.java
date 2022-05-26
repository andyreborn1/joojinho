package entities;

import main.Game;

public class Enemy extends Entity {
    public int life;

    public Enemy(String name, double x, double y, double speed, int life,
                 EntitySprites entitySprites) {
        super(name, x, y, speed, entitySprites);
        this.life = life;
    }

    public void tick() {
        this.down();
        if (getY() > Game.HEIGHT + 16) {
            Game.entities.remove(this);
        }

        for (int i = 0; i < Game.entities.size(); i++) {
            Entity e = Game.entities.get(i);

            if(e instanceof Bullet){
                if(Entity.isColidding(this, e)){
                    Game.entities.remove(e);
                    life-=((Bullet) e).damage;

                    if(this.life<1){
                        Explosion explosion = new Explosion("explosion",
                                this.getX(), this.getY(), 0,Game.explosionES);
                        Game.entities.add(explosion);
                        Game.entities.remove(this);
                    }
                }
            }
        }
    }
}
