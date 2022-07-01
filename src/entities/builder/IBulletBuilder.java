package entities.builder;

import entities.Bullet;
import entities.EntitySprites;
import main.Controller;

public interface IBulletBuilder {

    void setName(String name);

    void setX(double x);

    void setY(double y);

    void setSpeed(double speed);

    void setDamage(int damage);

    void setController(Controller controller);

    void setSprites(EntitySprites[] sprites);

    Bullet buildBullet();
}
