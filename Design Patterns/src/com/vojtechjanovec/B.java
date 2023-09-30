package com.vojtechjanovec;

public class B {
    public int id;

    public B(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+" - "+id+"";
    }
}
