package com.vojtechjanovec;

import java.lang.reflect.Array;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Person implements Runnable{
    private String name;
    private int drinkingSpeed;
    private int beersDrunken;
    private Table table;
    private ArrayBlockingQueue<String> queueForBeer;

    public Person(String name, int speed, Table table, ArrayBlockingQueue<String> queue) {
        this.name = name;
        Thread.currentThread().setName(name);
        this.drinkingSpeed = speed;
        this.table = table;
        this.queueForBeer = queue;
    }

    public void setBeersDrunk(int beersDrunk) {
        this.beersDrunken = beersDrunk;
    }

    public void drink(int drinkingSpeed) {
        String threadName = Thread.currentThread().getName();
        try {
            queueForBeer.put(name);
        } catch (InterruptedException e) {

        }
        while (queueForBeer.contains(name)) {
            Thread.yield();
        }
            try {
                System.out.println("Drinking!");
                Thread.currentThread().sleep(drinkingSpeed);


            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }

        }

    @Override
    public void run() {
        // Drinking!
        table.sit();
        for(int i=1; i<10; i++) {
            System.out.println(this.name+"--- Waiting for a beer");
            drink(drinkingSpeed);
            System.out.println(this.name+"--- Finished with drinking");
            beersDrunken++;
            System.out.println(this.name+"--- Beers drunked: "+beersDrunken);
        }
    }
}
