package main;

import entities.Entity;
import entities.iterator.EntityList;
import entities.iterator.Iterator;
import entities.visitor.Visitor;

import java.awt.*;
import java.util.LinkedList;

public class Controller {

    LinkedList<Entity> gameObjects = new LinkedList<>();
    EntityList collection;
    Iterator iterator;

    public Controller() {
        collection = new EntityList();
//        iterator = collection.getIterator(gameObjects);
    }

    public void tick() {
//        iterator = collection.getIterator();
//        while (iterator.hasNext()) {
//            Entity e = iterator.next();
//            e.tick();
//        }

        for (int i = 0; i < gameObjects.size(); i++) {
            Entity entity = gameObjects.get(i);

            entity.tick();
        }
    }

    public void render(Graphics graphics) {
//        iterator = collection.getIterator();
//        while (iterator.hasNext()) {
//            Entity e = iterator.next();
//            e.render(graphics);
//        }

        for (int i = 0; i < gameObjects.size(); i++) {
            Entity entity = gameObjects.get(i);

            entity.render(graphics);
        }
    }

    public void addEntity(Entity entity) {
//        collection.add(entity);
        gameObjects.add(entity);
    }

    public void removeEntity(Entity entity) {
//        collection.remove(entity);
        gameObjects.remove(entity);
    }

    public void checkCollision(Visitor visitor, Entity entity) {
//        iterator = collection.getIterator();
//        while (iterator.hasNext()) {
//            Entity e = iterator.next();
//            e.visit(visitor, entity);
//        }
        for (int i = 0; i < gameObjects.size(); i++) {
            Entity e = gameObjects.get(i);
            e.visit(visitor, entity);
        }
    }


    public void clear() {
        gameObjects.clear();
    }
}
