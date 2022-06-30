package entities.iterator;

import entities.Entity;

public interface Iterator {
    boolean hasNext();

    Entity next();

    void resetPosition();
}
