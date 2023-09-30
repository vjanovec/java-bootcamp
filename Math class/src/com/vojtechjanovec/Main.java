package com.vojtechjanovec;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] randomArray = new int[2][3];
        for(int i=0; i<randomArray.length; i++) {
            for(int j=0; j<randomArray[i].length; j++) {
                randomArray[i][j] = (int) (Math.random() * 50 +1);
            }
        }

        for(int i=0; i<randomArray[0].length; i++) {
            for(int j=0; j<randomArray.length; j++) {
                System.out.print(randomArray[j][i]+" ");
            }
            System.out.print("\n");
        }
        System.out.println("==========");

        for(int[] arr : randomArray) {
            for(int num : arr) {
                System.out.println(num);
            }
        }

        // Součet čísel pod diagonálou
        // pocet sloupcu deleno pocet radku
        int soucet = 0;
        for(int i=0; i<randomArray.length; i++) {
            for(int j=0; j<=i; j++) {
                System.out.println("Pricitam "+randomArray[i][j]);
                soucet += randomArray[i][j];
            }
        }

        System.out.println("Soucet "+ soucet);



    }
}
