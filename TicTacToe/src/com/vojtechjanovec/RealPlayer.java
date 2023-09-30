package com.vojtechjanovec;

import java.util.Scanner;

public class RealPlayer extends Player {

    Scanner userInput = new Scanner(System.in, "UTF-8");

    public RealPlayer(String name, String mark) {
        super(name, mark);
    }

    @Override
    public Tile chooseTile(Tile[][] tiles) {
        while (true) {
            try {
                System.out.println(super.getPlayerName() + " choose tile");
                System.out.println("Insert Tile X position: ");
                int inputX = Integer.parseInt(userInput.nextLine());
                System.out.println("Insert Tile Y position: ");
                int inputY = Integer.parseInt(userInput.nextLine());
                Tile selectedTile = tiles[inputX][inputY];
                return selectedTile;

            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException! Try again");

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ArrayIndexOutOfBoundsException, insert x and y between 0-2");

            }

        }
    }
}