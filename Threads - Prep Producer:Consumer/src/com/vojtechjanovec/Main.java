package com.vojtechjanovec;

public class Main {



    public static void main(String[] args) {
     /*   Countdown countdown = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");
        CountdownThread t3 = new CountdownThread(countdown);
        t3.setName("Thread 3");

        t1.start();
        t2.start();
        t3.start();


      */
        // Ukol 1 & 2

 /*       RandomThread t1 = new RandomThread();
        t1.setName("Thread1");
        RandomThread t2 = new RandomThread();
        t2.setName("Thread2");
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        } catch(InterruptedException e) {

        }

        System.out.println("Běh vláken dokončen");

    }
*/
        // Ukol 3

        // - PriorityBlockingQueue - synchronizovaná prioritní fronta
        Buffer buffer = new Buffer();
        Producent producent = new Producent(buffer);
        Konzument konzument = new Konzument(buffer);
        producent.start();
        konzument.start();


    }

}
