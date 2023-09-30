package com.vojtechjanovec;

import java.util.concurrent.LinkedBlockingQueue;

public class Main {



    public static void main(String[] args) {

        LinkedBlockingQueue<String> queueForBeer = new LinkedBlockingQueue();

        Table table1 = new Table("Table1", queueForBeer);
        Table table2 = new Table("Table2", queueForBeer);
        Table table3 = new Table("Table3", queueForBeer);
        Table table4 = new Table("Table4", queueForBeer);
        Table table5 = new Table("Table5", queueForBeer);

        Person marek = new Person("Marek", 5000, table1, queueForBeer);
        Person karel = new Person("Karel", 8000, table1, queueForBeer);
        Person aksel = new Person("Aksel", 4000, table1, queueForBeer);
        Waiter cisnik1 = new Waiter("Tonda", 5, 20000, queueForBeer);
        Thread cisnikThread = new Thread(cisnik1);
        Thread zakaznik1Thread = new Thread(marek);
        Thread zakaznik2Thread = new Thread(karel);
        Thread zakaznik3Thread = new Thread(aksel);
        cisnikThread.start();
        zakaznik1Thread.start();
        zakaznik2Thread.start();
        zakaznik3Thread.start();

    }

}
