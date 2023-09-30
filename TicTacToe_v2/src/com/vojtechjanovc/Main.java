package com.vojtechjanovc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Player firstPlayer = new RealPlayer("FirstPlayer");
        Player secondPlayer = new RealPlayer("SecondPlayer");
        Game game = new Game(firstPlayer, secondPlayer);
        game.start();
    }
}
