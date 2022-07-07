package entities;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class EntitySpriteFactory {
    static Map<String, EntitySprites> sprites = new HashMap<>();

    private EntitySpriteFactory(){
        throw new IllegalStateException("Utility class");
    }

    public static EntitySprites getSprite(String name, BufferedImage sprite) {
        EntitySprites result = sprites.get(name);
        if (result == null) {
            result = new EntitySprites(sprite);
            sprites.put(name, result);
        }

        return result;
    }
}
