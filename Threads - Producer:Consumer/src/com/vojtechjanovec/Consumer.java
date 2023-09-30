package com.vojtechjanovec;

public class Consumer extends Thread {

    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for(;;) {
            System.out.println("Ziskana hodnota "+buffer.get());
        }
    }

}
