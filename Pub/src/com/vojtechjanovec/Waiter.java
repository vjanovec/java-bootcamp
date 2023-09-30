package com.vojtechjanovec;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Waiter implements Runnable{

    private String waiterName;
    private int beerCapacity;
    private int servingTime;
    private LinkedBlockingQueue<String> queueForBeer;

    public Waiter(String waiterName, int beerCapacity, int servingTime, LinkedBlockingQueue<String> queueForBeer) {
        this.waiterName = waiterName;
        this.beerCapacity = beerCapacity;
        this.servingTime = servingTime;
        this.queueForBeer = queueForBeer;
    }

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println(this.waiterName+" --- Cisnik Reffiling beers");
                Thread.sleep(servingTime);
                Thread refill = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        beerRefill(beerCapacity);
                    }
                });
                refill.setName(this.waiterName);
                refill.start();
                Thread.yield();
                System.out.println(this.waiterName+" --- Beers served");
            } catch(InterruptedException e) {

            }
        }
    }


    public void beerRefill(int beers) {
        System.out.println(Thread.currentThread().getName()+"Beers served ("+beers+")");
        for(int i=0; i<beers; i++) {
            try {
                queueForBeer.take();

            } catch(InterruptedException e) {

            }

        }

    }

    public String getWaiterName() {
        return waiterName;
    }

    public int getBeerCapacity() {
        return beerCapacity;
    }

    public int getServingTime() {
        return servingTime;
    }
}
