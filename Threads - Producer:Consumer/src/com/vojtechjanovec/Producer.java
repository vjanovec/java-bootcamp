package com.vojtechjanovec;

public class Producer extends Thread {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for(int i=0; ;i++) {
            buffer.set(i);
        }
    }
}
