package com.vojtechjanovec;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here\
        int i = 6;
        do {
            System.out.println(i);
        } while (i < 5);


        Scanner sc = new Scanner(System.in, "UTF-8");
        System.out.println("Insert A: ");
        double a = 0;
        while (a == 0) {
            a = sc.nextDouble();
            if (a == 0) {
                System.out.println("A se nesmí rovnat 0");
            }
        }
        System.out.println("Insert B: ");
        double b = sc.nextDouble();
        System.out.println("Insert C: ");
        double c = sc.nextDouble();
        double diskriminant = (b * b) - (4 * a * c);
        if (diskriminant > 0) {
            double x1 = (-b + Math.sqrt(diskriminant) / (2 * a));
            double x2 = (-b - Math.sqrt(diskriminant) / (2 * a));
            System.out.println("Diskriminant: " + diskriminant);
            System.out.println("X1: " + x1);
            System.out.println("X2: " + x2);
            System.out.println("Rovnice má 2 kořeny");
        } else if (diskriminant == 0) {
            double x = -b / (2 * a);
            System.out.println("Rovnice má jeden kořen");
        } else {
            System.out.println("Diskriminant je záporný (" + diskriminant + ")");
            System.out.println("Kořeny nemá");
        }


    }
}
