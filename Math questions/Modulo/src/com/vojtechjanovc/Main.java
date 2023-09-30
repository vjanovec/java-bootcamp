package com.vojtechjanovc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "UTF-8");
        int userInput = Integer.parseInt(sc.nextLine());
        int value = Math.abs(userInput);
        int cifernySoucet = 0;
        while (value > 10) {
            int modulo = value % 10;
            cifernySoucet += modulo;
            value -= modulo;
            value /= 10;
        }
        cifernySoucet += value;
//        if (value < 0) {
//            cifernySoucet *= (-1);
//        }
        System.out.println(cifernySoucet);

    }

}
