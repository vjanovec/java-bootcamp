package com.vojtechjanovec;

import java.util.Random;

public class RandomThread extends Thread {

    Random random= new Random();

    private int counter;

    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            int randomNumber = random.nextInt(100);
            if(randomNumber<=5) {
                System.out.println("Cislo mensi nez 5");
                break;
            } else {
                System.out.println(Thread.currentThread().getName()+"    Náhodné číslo: "+randomNumber+"        Vypsáno čísel: "+counter);
                counter++;
            }

        }
    }
}
