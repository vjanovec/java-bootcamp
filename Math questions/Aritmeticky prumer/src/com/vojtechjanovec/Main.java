package com.vojtechjanovec;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in, "UTF-8");
        //boolean wantContinue = true;
        int totalSum = 0;
        int numbersInserted = 0;
        while(/*wantContinue == true*/true) {
            System.out.println("Insert number: ");
            try {
                int insertedNumber = Integer.parseInt(sc.nextLine());
                if(insertedNumber != 0) {
                    totalSum += insertedNumber;
                    numbersInserted++;
                } else if(insertedNumber == 0) {
                    break;
                } else {
                    continue;
                }


            } catch(NumberFormatException e) {
                System.out.println("Insert only numbers!");
                continue;
            }
        }
        double arithmeticMean = (double) totalSum/numbersInserted;
//
//        try {
//            arithmeticMean =
//        } catch(IllegalArgumentException e) {
//            System.out.println("Cant divide by zero!");
//        }

        System.out.println("Aritmeticky prumer: "+arithmeticMean);

    }
}
