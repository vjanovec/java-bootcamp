package com.vojtechjanovc;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // Palindrom project
        String input = "lammal";
        char[] array = input.toCharArray();
        char[] newArray = input.toCharArray();
        for(int i=0; i<(newArray.length/2); i++) {
            char tempChar = newArray[i];
            newArray[i] = newArray[newArray.length-1-i];
            newArray[newArray.length-1-i] = tempChar;
        }
        System.out.println("Array: ");
        for(char c : array) {
            System.out.print(c);
        }
        System.out.println("\nNew array ");
        for(char c : newArray) {
            System.out.print(c);
        }
        if(Arrays.equals(array, newArray)) {
            System.out.println("\nAno, jedná se o palindrom");
        } else {
            System.out.println("\nNe, toto není palindrom");
        }


    }
}
