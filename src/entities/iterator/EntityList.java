package entities.iterator;

import entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class EntityList {
    private List<Entity> objects = new ArrayList<>();

    public Iterator getIterator() {
        return new EntityIterator(this);
    }

    public void add(Entity entity) {
        objects.add(entity);
    }

    public void remove(Entity entity) {
        objects.remove(entity);
    }

    public List<Entity> getObjects() {
        return this.objects;
    }
}
