package com.vojtechjanovc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in, "UTF-8");
        System.out.println("Zadej hledaný objekt: ");
        String input = sc.nextLine().toLowerCase();
        String[] zelenina = {"zeli", "okurka", "rajce", "paprika", "redkev", "mrkev", "brokolice"};
        String[] ovoce = {"jablko", "hruska", "pomeranc", "jahoda", "banan", "kiwi", "malina"};
        Arrays.sort(zelenina);
        Arrays.sort(ovoce);
        if (Arrays.binarySearch(ovoce, input) >=0) {
            System.out.println(Arrays.binarySearch(ovoce, input));
            System.out.println("Jedna se o ovoce");
        } else if (Arrays.binarySearch(zelenina, input) >=0) {
            System.out.println(Arrays.binarySearch(zelenina, input));
            System.out.println("Jedna se o zeleninu");
        } else {
            System.out.println(Arrays.binarySearch(ovoce, input));
            System.out.println(Arrays.binarySearch(zelenina, input));
            System.out.println("Hledany objekt nebzl nalezen v žádném poli");
        }
    }
}
