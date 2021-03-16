package org.tveki.games.setgame.model;

public enum Number implements Feature {

    ONE(1),
    TWO(2),
    THREE(3);

    private int value;

    Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
