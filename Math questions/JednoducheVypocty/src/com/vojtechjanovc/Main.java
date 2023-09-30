package com.vojtechjanovc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        // Vypočítejte obvod a obsah kruhu se vstupem z klávesnice
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Zadej polomer kruhu");
            double polomer = Double.parseDouble(sc.nextLine());

            double obvod = 2 * Math.PI * polomer;
            double obsah = Math.PI * Math.pow(polomer, 2);
            System.out.println("Obvod kruhu = " + obvod);
            System.out.println("Obsah kruhu = " + obsah);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input format");
        }


        try {
            System.out.println("Který údaj chcete zadat?");
            System.out.println("1. Poloměr\n2.Průměr\n3.Obvod\n4.Obsah");
            int option = Integer.parseInt(sc.nextLine());
            System.out.println("Zadejte hodnotu: ");
            double value = Double.parseDouble(sc.nextLine());
            Kruh kruh = null;
            switch (option) {
                case 1:
                    kruh = new Kruh(value, 0, 0, 0);
                    System.out.println("Kruh vytvořen");
                    break;
                case 2:
                    kruh = new Kruh(0, value, 0, 0);
                    System.out.println("Kruh vytvořen");
                    break;
                case 3:
                    kruh = new Kruh(0, 0, value, 0);
                    System.out.println("Kruh vytvořen");
                    break;
                case 4:
                    kruh = new Kruh(0, 0, 0, value);
                    System.out.println("Kruh vytvořen");
                    break;
                default:
                    System.out.println("Špatně zadané!");
                    break;
            }
            System.out.println(kruh.toString());
        } catch(NullPointerException e) {
            System.out.println("NullPointerException");
        } catch(NumberFormatException e) {
            System.out.println("NumberFormatException");
        }

    }
}
