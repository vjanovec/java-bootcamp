package com.vojtechjanovec;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here

        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
