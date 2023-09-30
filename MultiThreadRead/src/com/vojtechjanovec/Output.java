package com.vojtechjanovec;

public class Output {

    private int total;

    public Output() {
        this.total = 0;
    }

    public synchronized int getTotal() {
        return total;
    }

    public synchronized void add() {
        this.total++;
    }
}
