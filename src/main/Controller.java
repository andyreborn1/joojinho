package main;

import entities.Entity;
import entities.visitor.Visitor;

import java.awt.*;
import java.util.LinkedList;

public class Controller {

    private LinkedList<Entity> gameObects = new LinkedList<>();
    public Game game;

    public Controller(Game game) {
        this.game = game;
    }

    public void tick() {
        for (int i = 0; i < gameObects.size(); i++) {
            Entity entity = gameObects.get(i);

            entity.tick();
        }
    }

    public void render(Graphics graphics) {
        for (int i = 0; i < gameObects.size(); i++) {
            Entity entity = gameObects.get(i);

            entity.render(graphics);
        }
    }

    public void addEntity(Entity entity) {
        gameObects.add(entity);
    }

    public void removeEntity(Entity entity) {
        gameObects.remove(entity);
    }

    public void checkCollision(Visitor visitor, Entity entity) {
        for (int i = 0; i < gameObects.size(); i++) {
            Entity e = gameObects.get(i);
            e.visit(visitor, entity);
        }
    }


    public void clear() {
        gameObects.clear();
    }
}
