package com.vojtechjanovec;
import java.util.concurrent.LinkedBlockingQueue;


public class Table {

    Object o = new Object();

    private String tableName;
    private int beersRequired;
    private LinkedBlockingQueue<String> queueForBeer;


    public Table(String tableName, LinkedBlockingQueue<String> queue) {
        this.tableName = tableName;
        queueForBeer = queue;
    }

    public void sit() {
        System.out.println(Thread.currentThread().getName()+" sat at the table "+tableName);
    }





    public String getTableName() {
        return tableName;
    }
}
