package com.vojtechjanovc;

public abstract class Player {

    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public abstract int[] chooseTile();


}
