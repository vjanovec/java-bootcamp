package com.vojtechjanovec;


public class Game {
    private Player xPlayer;
    private Player oPlayer;
    private Tile[][] tiles;

    public Game(Player xPlayer, Player oPlayer) {
        this.xPlayer = xPlayer;
        this.oPlayer = oPlayer;
        this.tiles = new Tile[3][3];
        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                tiles[x][y] = new Tile(x, y, false);
                System.out.println("Tile x=" + x + " y=" + y + " created!");
            }
        }
    }

    public void placeMark(Player player, int x, int y) {

    }

    public boolean areAllTilesOccupied() {
        boolean result = true;
        for (Tile[] tile1 : tiles) {
            for (Tile tile2 : tile1) {
                if (!tile2.isOccupied()) {
                    result = false;
                }
            }
        }
        System.out.println("All tiles are occupied");
        return result;
    }

    public boolean wonSomeone(String mark) {
        for (Tile[] tile1 : tiles) {
            if(tile1[0].getPlayer().equals(tile1[1].getPlayer().equals(tile1[2]))) {
                System.out.println(tile1[0].getPlayer());
                return true;
            }




            for (Tile tile2 : tile1) {
                int tileX = tile2.getX();
                int tileY = tile2.getY();
                //System.out.println(tileX+" "+tileY);
                // X VERTICAL


                if (tileX == 0) {
                    if (tile2.getPlayer().equals(mark) && tiles[tileX + 1][tileY].getPlayer().equals(mark) && tiles[tileX + 2][tileY].getPlayer().equals(mark)) {
                        System.out.println(mark + " WON");
                        return true;
                    }
                } else if (tileX == 1) {
                    if (tile2.getPlayer().equals(mark) && tiles[tileX - 1][tileY].getPlayer().equals(mark) && tiles[tileX + 1][tileY].getPlayer().equals(mark)) {
                        System.out.println(mark + " WON");
                        return true;
                    }
                } else if (tileX == 2) {
                    if (tile2.getPlayer().equals(mark) && tiles[tileX - 1][tileY].getPlayer().equals(mark) && tiles[tileX - 2][tileY].getPlayer().equals(mark)) {
                        System.out.println(mark + " WON");
                        return true;
                    }
                    // Y HORIZONTAL
                }
                if (tileY == 0) {
                    if (tile2.getPlayer().equals(mark) && tiles[tileX][tileY + 1].getPlayer().equals(mark) && tiles[tileX][tileY + 2].getPlayer().equals(mark)) {
                        System.out.println(mark + " WON");
                        return true;
                    }
                } else if (tileY == 1) {
                    if (tile2.getPlayer().equals(mark) && tiles[tileX][tileY - 1].getPlayer().equals(mark) && tiles[tileX][tileY + 1].getPlayer().equals(mark)) {
                        System.out.println(mark + " WON");
                        return true;
                    }
                } else if (tileY == 2) {
                    if (tile2.getPlayer().equals(mark) && tiles[tileX][tileY - 1].getPlayer().equals(mark) && tiles[tileX - 2][tileY].getPlayer().equals(mark)) {
                        System.out.println(mark + " WON");
                        return true;
                    }
                }
                // DIAGONAL
                // DIAGONAL

                if (tileX == 0 && tileY == 0) {
                    if (tile2.getPlayer().equals(mark) && tiles[tileX + 1][tileY + 1].getPlayer().equals(mark) && tiles[tileX + 2][tileY + 2].getPlayer().equals(mark)) {
                        System.out.println(mark + " WON");
                        return true;
                    }
                } else if (tileX == 0 && tileY == 2) {
                    if (tile2.getPlayer().equals(mark) && tiles[tileX + 1][tileY - 1].getPlayer().equals(mark) && tiles[tileX + 2][tileY - 2].getPlayer().equals(mark)) {
                        System.out.println(mark + " WON");
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public void startGame() {
        boolean end = false;

        Tile choosenTile = null;
        while (!end) {


            // Check occupancy
            if (areAllTilesOccupied() || wonSomeone("O")) {
                end = true;
                break;
            }
            // First player, choose tile, place mark
            choosenTile = xPlayer.chooseTile(tiles);

            while (!choosenTile.occupyTile(xPlayer.getMark())) {
                System.out.println("Tile is already occupied, try it again");
                choosenTile = xPlayer.chooseTile(tiles);
            }
            System.out.println("Successfully places X on tile (x=" + choosenTile.getX() + " y=" + choosenTile.getY() + ")");


            // Check occupancy
            if (areAllTilesOccupied() || wonSomeone("X")) {
                end = true;
                break;
            }
            // Second player, choose tile, place mark
            choosenTile = oPlayer.chooseTile(tiles);

            while (!choosenTile.occupyTile(oPlayer.getMark())) {
                System.out.println("Tile is already occupied, try it again");
                choosenTile = oPlayer.chooseTile(tiles);
            }
            System.out.println("Successfully places X on tile (x=" + choosenTile.getX() + " y=" + choosenTile.getY() + ")");
        }
    }

}

