package com.vojtechjanovec;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert longer word: ");
        String longerWord = sc.nextLine().trim();

        System.out.println("Insert shorter word: ");
        String shorterWord = sc.nextLine().trim();
        int lenghtDifference = Math.abs(longerWord.length() - shorterWord.length());


        System.out.println("First word is " + lenghtDifference + " characters longer then second word.");
    }
}
