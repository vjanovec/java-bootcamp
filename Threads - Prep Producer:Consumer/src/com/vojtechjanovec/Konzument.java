package com.vojtechjanovec;

import java.util.concurrent.TimeUnit;

public class Konzument extends Thread {
    private Buffer buffer;

    public Konzument(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
    /*    try{
            //Thread.sleep(TimeUnit.SECONDS.toMillis(5));

        } catch(InterruptedException e){

        }*/
        System.out.println("konzument");
        for(int i=0; i<49; i++) {
            buffer.get();
        }
        System.out.println("konzument- finish");
    }
}
