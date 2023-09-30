package com.vojtechjanovec;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Main {

    static String bar = "";

    public static void main(String[] args) {
        // Testing project to learn how to use Time in Java
        Date currentDate = new Date();
        System.out.println(currentDate);

        Random random = new Random();


        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (bar) {
                        int randomNum = random.nextInt(3);
                        if (randomNum == 1) {
                            bar += "#";
                        } else if(randomNum == 2){
                            bar += " ";
                        } else {
                            bar += "X";
                        }
                        try {
                            Thread.sleep(500);
                            System.out.println(bar);
                        } catch (InterruptedException e) {

                        }
                    }
                }
            }
        });
        myThread.start();


    }
}
