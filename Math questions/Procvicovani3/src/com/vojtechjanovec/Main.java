package com.vojtechjanovec;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in, "UTF-8");
        System.out.println("Zadej řetězec");
        String userInput = sc.nextLine();
        System.out.println(userInput.toLowerCase().contains("itstep"));

    }
}
