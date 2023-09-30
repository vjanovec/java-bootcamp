package com.vojtechjanovec;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //    Program bude obsahovat několik pokladen (např.3) a několik zákazník k obsluze (např. 10).
        //    Zákazníci budou přidělovány k různým přepážkám podle množství zboží. Odbavení jedné položky nákupu potrvá 0,5s. Velikost nákupu generujte náhodně.
        //    Vypište statistiku kolik zákazníků a zboží která přepážka odbavila .
        //    Zákazníky si vygenerujte, stačí, aby v košíku bylo jen kolik mají položek. Tyto zákzníci budou v hlavní frontě a rozvrhovač (radič) je bude dávat do front s různou prioritou. Použijte priority vláken.

        Queue<Customer> customers = new LinkedBlockingQueue<>();


//        for (int i = 0; i < 100; i++) {
//            Customer customer = new Customer(i, new Random().nextInt(50));
//            customers.offer(customer);
//        }

        // 3 pokladny
        Checkout ch1 = new Checkout(1, customers);
        Checkout ch2 = new Checkout(2, customers);
        Checkout ch3 = new Checkout(3, customers);
//        Thread t1 = new Thread(ch1);
//        Thread t2 = new Thread(ch2);
//        Thread t3 = new Thread(ch3);
        ch1.start();
        ch2.start();
        ch3.start();

        ch1.setPriority(4);
        ch2.setPriority(8);
        ch3.setPriority(5);

        Thread prichodZakazniku = new Thread() {
            @Override
            public void run() {
                int lastCustomer = 0;
                while(true) {
                    lastCustomer++;
                    Customer customer = new Customer(lastCustomer, new Random().nextInt(50));
                    customers.offer(customer);
                    lastCustomer++;
                    synchronized (customers) {
                        notifyAll();
                    }
                    try {
                        Thread.sleep(new Random().nextInt(2000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        prichodZakazniku.start();


        try {
            ch1.join();
            ch2.join();
            ch3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Odbaveni vsichni zakaznici");

    }
}
