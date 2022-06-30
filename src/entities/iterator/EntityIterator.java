package entities.iterator;

import entities.Entity;

import java.util.List;

public class EntityIterator implements Iterator {
    private EntityList entityList;
    private List<Entity> entities;
    private int curPosition = 0;

    public EntityIterator(EntityList entityList) {
        this.entityList = entityList;
    }

    @Override
    public boolean hasNext() {
        lazyLoad();
        return curPosition < entities.size();
    }

    @Override
    public Entity next() {
        Entity e = entities.get(curPosition);
        curPosition++;
        return e;
    }

    public void lazyLoad() {
        if (entities == null) {
            entities = entityList.getObjects();
        }
    }

    @Override
    public void resetPosition() {
        curPosition = 0;
    }
}
