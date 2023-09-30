package com.vojtechjanovec;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in, "UTF-8");
        System.out.println("Zadej větu, kterou chcete zašifrovat: ");
        String input = sc.nextLine();
        char[] array = input.toCharArray();
        for(int i=0; i<array.length; i++) {
            array[i]++;
        }
        for(char c : array) {
            System.out.print(c);
        }
        System.out.print("\n");

        System.out.println("Zadejte větu, kterou chcete dešifrovat: ");
        input = sc.nextLine();
        array = input.toCharArray();
        for(int i=0; i<array.length; i++){
            array[i]--;
        }
        for(char c : array) {
            System.out.print(c);
        }
    }
}
