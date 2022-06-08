package entities.chain;

import entities.Entity;

public abstract class CollisionHandler {
    private CollisionHandler next;

    public CollisionHandler linkNext(CollisionHandler next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(Entity e1, Entity e2);

    protected boolean checkNext(Entity e1, Entity e2) {
        if (next == null) return true;

        return next.check(e1, e2);
    }
}
