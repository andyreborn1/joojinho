package main.observer;

import java.util.ArrayList;

public class EventListener {
    private ArrayList<Observer> listeners = new ArrayList<>();


    public void getScore(int score) {
        update(score);
    }

    public void subscribe(Observer o) {
        listeners.add(o);
    }

    public void unsubscribe(Observer o) {
        listeners.remove(o);
    }

    public void update(int score) {
        for (Observer o : listeners) {
            o.update(score);
        }
    }
}
