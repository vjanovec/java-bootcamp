package com.vojtechjanovec;

public class A {
    public int id;

    public A(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+" - "+id+"";
    }
}
