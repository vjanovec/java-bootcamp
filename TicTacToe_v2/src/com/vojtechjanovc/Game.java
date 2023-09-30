package com.vojtechjanovc;

import java.rmi.activation.ActivationGroup_Stub;

public class Game {
    private Player[][] tiles;
    private Player xPlayer;
    private Player oPlayer;
    private Player[] players;
    private Player nullPlayer;

    public Game(Player xPlayer, Player oPlayer) {
        this.xPlayer = xPlayer;
        this.oPlayer = oPlayer;
        this.tiles = new Player[3][3];

    }


    public void start() {
        int remainingTiles = 9;
        while (remainingTiles > 0 && !winning()) {
            while (remainingTiles > 0 && !winning()) {
                int[] choosenTile = xPlayer.chooseTile();
                if (tiles[choosenTile[0]][choosenTile[1]] == null) {
                    tiles[choosenTile[0]][choosenTile[1]] = xPlayer;
                    remainingTiles--;
                    break;
                } else {
                    System.out.println("Tile occupied, try again");
                }
            }
            while (remainingTiles > 0 && !winning()) {
                int[] choosenTile = oPlayer.chooseTile();
                if (choosenTile[0] < 3 && choosenTile[1] < 3) {
                    if (tiles[choosenTile[0]][choosenTile[1]] == null) {
                        tiles[choosenTile[0]][choosenTile[1]] = oPlayer;
                        remainingTiles--;
                        break;
                    } else {
                        System.out.println("Tile occupied or not found, try again ");
                    }
                }

            }
        }
        System.out.println("Game over");
    }

    public boolean winning() {
        try {
            for (Player[] tileRow : tiles) {
                if (tileRow[0] != null && tileRow[1] != null && tileRow[2] != null) {
                    if (tileRow[0].equals(tileRow[1]) && tileRow[1].equals(tileRow[2])) {
                        return true;
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                if (tiles[0][i] != null && tiles[1][i] != null && tiles[2][i] != null) {

                    if (tiles[0][i].equals(tiles[1][i]) && tiles[1][i].equals(tiles[2][i])) {
                        return true;
                    }
                }
            }
            if (tiles[0][0] != null && tiles[1][1] != null && tiles[2][2] != null) {
                if (tiles[0][0].equals(tiles[1][1]) && tiles[1][1].equals(tiles[2][2])) {
                    return true;
                }
            }
            if(tiles[0][2] != null && tiles[1][1] != null && tiles[2][0] != null) {
                if (tiles[0][2].equals(tiles[1][1]) && tiles[2][0].equals(tiles[2][2])) {
                    return true;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointer");
        }
        return false;
    }
}
