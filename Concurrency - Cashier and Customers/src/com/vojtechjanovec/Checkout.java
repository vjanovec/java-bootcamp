package com.vojtechjanovec;

import java.util.Queue;

public class Checkout extends Thread {
    private int checkoutId;
    private int odbavenoZakazniku;
    private int odbavneoPolozek;

    private Queue zakaznici;

    public Checkout(int checkoutId, Queue zakaznici) {
        this.checkoutId = checkoutId;
        this.zakaznici = zakaznici;
        //run();
    }

    @Override
    public void run() {
            Customer customer = null;
            while (true) {
                while (!zakaznici.isEmpty()) {
                    synchronized (zakaznici) {
                        if (!zakaznici.isEmpty()) {
                            customer = (Customer) zakaznici.poll();
                            System.out.println("Pokladna " + this.getCheckoutId() + " --- Zakaznik " + customer.getCustomerId() + " byl odbaven");
                            odbavneoPolozek += customer.getBasket();
                            odbavenoZakazniku++;
                        }
                    }
                    try {
                        if (customer != null) {
                            Thread.sleep(customer.getBasket() * 100);
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Pokladna " + this.getCheckoutId() + " --- celkem zakazniku: "+this.odbavenoZakazniku+" --- celkem položek: "+this.odbavneoPolozek+" --- prumerne polozek: "+ (this.odbavenoZakazniku != 0 ? odbavneoPolozek/this.odbavenoZakazniku : 0));
                try {
                    synchronized(this) {
                        this.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

    }

    public int getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(int checkoutId) {
        this.checkoutId = checkoutId;
    }

    public int getOdbavenoZakazniku() {
        return odbavenoZakazniku;
    }

    public void setOdbavenoZakazniku(int odbavenoZakazniku) {
        this.odbavenoZakazniku = odbavenoZakazniku;
    }

    public int getOdbavneoPolozek() {
        return odbavneoPolozek;
    }

    public void setOdbavneoPolozek(int odbavneoPolozek) {
        this.odbavneoPolozek = odbavneoPolozek;
    }


}
