package entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EntitySprites {
    protected BufferedImage sprite;

    public EntitySprites(BufferedImage sprite) {
        this.sprite = sprite;
    }


    public void render(String name, Graphics graphics, double x, double y) {
        graphics.drawImage(this.sprite, (int) x, (int) y, null);
    }

    public void tick() {
    }
}
