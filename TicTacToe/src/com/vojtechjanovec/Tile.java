package com.vojtechjanovec;

public class Tile {

    private int x;
    private int y;
    private boolean isOccupied;
    private Player player;

    public Tile(int x, int y, boolean isOccupied) {
        this.x = x;
        this.y = y;
        this.isOccupied = isOccupied;
        player = null;
    }

    public boolean occupyTile(Player player) {
        if(!isOccupied) {
            isOccupied = true;
            this.player = player;
            return true;
        } else {
            return false;
        }
    }
    public void clearTile() {
        isOccupied = false;
        player = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Player getPlayer() {
        return player;
    }
}
