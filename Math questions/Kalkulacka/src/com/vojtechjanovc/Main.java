package com.vojtechjanovc;

import java.util.Scanner;

public class Main {

    public static class DivideByZeroException extends Exception {

    }




    public static void main(String[] args) {
	// write your code here

        double x = 5.8F;
        double y = 0;
        System.out.println(x/y);

        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Welcome");
            System.out.println("Insert number: ");
            double a = Double.parseDouble(sc.nextLine());
            System.out.println("Insert number: ");
            double b = Double.parseDouble(sc.nextLine());
            if(b == 0) {
                throw new DivideByZeroException();
            }
            double plus = a+b;
            double minus = a-b;
            double multiply = a*b;
            double divide = a/b;
            System.out.println("Soucet = "+plus);
            System.out.println("Rozdil = "+minus);
            System.out.println("Soucin = "+multiply);
            System.out.println("Podil = "+divide);
        } catch(NumberFormatException e) {
            System.out.println("Invalid input type");
        } catch(DivideByZeroException e) {
            System.out.println("Cant divide by zero!");
        }


    }
}
