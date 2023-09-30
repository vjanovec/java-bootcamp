package com.vojtechjanovec;

public class Buffer {

    private int x = -1;
    private boolean set = false;

    public synchronized void set(int value) {
        while(set) {
            try {
                wait();
            } catch(InterruptedException ex) {
                System.out.println("Přerušeno");
            }
        }
        set = true;
        this.x = value;
        System.out.println("Nastavena hodnota "+value);
        notifyAll();
    }

    public synchronized int get() {
        while(!set) {
            try {
                wait();
            } catch(InterruptedException ex) {
                System.out.println("Přerušeno");
            }
        }
        set = false;
        notifyAll();
        return x;

    }











}
