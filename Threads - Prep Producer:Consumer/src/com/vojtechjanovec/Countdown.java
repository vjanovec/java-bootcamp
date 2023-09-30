package com.vojtechjanovec;

public class Countdown {
    int x = 0;

    public void doCountdown() {


        while (x < 100) {
            synchronized (this) {
                if (x < 100) {
                    System.out.println(Thread.currentThread().getName() + " " + x);
                    x++;


                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {

                    }

                } else {

                }
            }

        }


    }
}