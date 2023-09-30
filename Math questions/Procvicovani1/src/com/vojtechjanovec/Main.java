package com.vojtechjanovec;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert your first name: ");
        String fName = sc.nextLine();
        System.out.println("Insert your last name: ");
        String lName = sc.nextLine();
        System.out.println("Insert your age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.printf("%s %s\n",fName.toUpperCase(), lName.toUpperCase());
        System.out.println("Next year you are going to be "+(age+1));
    }


}
