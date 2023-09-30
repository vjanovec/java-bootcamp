package com.vojtechjanovec;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player player1 = new RealPlayer("Player1", "X");
        Player player2 = new RealPlayer("Player2", "O");
        Game game = new Game(player1, player2);
        game.startGame();
    }
}
