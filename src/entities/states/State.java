package entities.states;

import entities.Player;

public abstract class State {
    Player player;

    public State(Player player) {
        this.player = player;
    }

    public abstract void onShot();
}
