package com.vojtechjanovec;

import java.io.Serializable;

public class ObjectToSend implements Serializable {
    private int id;

    public ObjectToSend(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
