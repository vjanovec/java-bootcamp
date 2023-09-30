package com.vojtechjanovec;

import java.util.concurrent.PriorityBlockingQueue;

public class Buffer {
    private PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue();

    public void get() {
        try {
            int poll = queue.take();
            System.out.println(poll);

        } catch (InterruptedException e) {

        }
    }
    public synchronized void set(int value) {
        queue.put(value);
        }

}
