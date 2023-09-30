package com.vojtechjanovec;

public abstract class Player {
    private String playerName;
    private String mark;

    public Player(String playerName, String mark) {
        this.playerName = playerName;
        this.mark = mark;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getMark() {
        return mark;
    }

    public abstract Tile chooseTile(Tile[][] tiles);
}
