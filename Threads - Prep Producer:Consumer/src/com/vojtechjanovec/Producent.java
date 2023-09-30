package com.vojtechjanovec;

import java.util.concurrent.TimeUnit;

public class Producent extends Thread{
    private Buffer buffer;

    public Producent(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        System.out.println("Producent");
        for(int i=1; i<50; i++) {
            try {
                //System.out.println("Producent before sleep");
                Thread.sleep(TimeUnit.SECONDS.toMillis(1));
                buffer.set(i);
            } catch(InterruptedException e) {
                System.out.println("Interrupted");
           }
        }
        System.out.println("Producent - finish");
    }
}
