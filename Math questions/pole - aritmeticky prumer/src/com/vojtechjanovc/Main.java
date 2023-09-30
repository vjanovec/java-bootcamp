package com.vojtechjanovc;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in, "UTF-8");
        System.out.println("How many numbers do you want to insert?");
        try {

            int numberOfValues = Integer.parseInt(sc.nextLine());
            int[] array = new int[numberOfValues];
            int totalSum = 0;
            for (int i = 0; i < numberOfValues; i++) {
                System.out.println("Insert " + (i+1) + " number: ");
                int insertedValue = Integer.parseInt(sc.nextLine());
                array[i] = insertedValue;
                totalSum += insertedValue;
            }
            double average = (double) totalSum / numberOfValues;
            System.out.println("Arithmetic mean: "+average);
            int abovePar = 0;
            for(int value : array) {
                if(value > average) {
                    abovePar++;
                }
            }
            System.out.println("Počet nadprůměrných hodnot "+abovePar);
            Arrays.sort(array);
            System.out.println("Minimum: "+array[0]);
            System.out.println("Maximum: "+array[array.length-1]);




        } catch (NumberFormatException e) {
            System.out.println("Insert only numbers!");

        }

    }
}
