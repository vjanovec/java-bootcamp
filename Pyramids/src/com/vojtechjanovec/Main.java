package com.vojtechjanovec;

public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }

        System.out.println("=====================================");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (j >= i) {
                    System.out.print("*");
                }
            }
            System.out.print("\n");
        }
        System.out.println("=====================================");

        for (int i = 6; i > 0; i--) {
            for (int j = 0; j <= 6; j++) {
                if (j >= i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
        System.out.println("=====================================");


    }
}
