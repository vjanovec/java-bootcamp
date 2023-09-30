package com.vojtechjanovec;

public class Bot extends Player {
    public Bot(String playerName, String mark) {
        super(playerName, mark);
    }

    @Override
    public Tile chooseTile(Tile[][] tiles) {
        return null;
    }
}
