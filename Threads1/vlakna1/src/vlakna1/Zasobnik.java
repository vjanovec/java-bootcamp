package vlakna1;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author virtuoso
 */
public class Zasobnik {

    List<Double> retezec = new ArrayList<>(); // proměnná na uložení předávaného řetězce
    boolean vlozenRetezec = false; // přepínač, který signalizuje,
// zda je něco uloženo v řetězci


    public synchronized boolean vlozenRetezec() {
        return vlozenRetezec;
    }

    public synchronized void setVlozenRetezec(boolean b) {
        vlozenRetezec = b;
    }
    
    public synchronized int velikost() {
       return retezec.size();
    }
    
    public synchronized void ulozDoZasobniku(double s) {
        while (vlozenRetezec()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.out.println("Ulozeni - InterruptedException");
            }
        }
        retezec.add(s);
        setVlozenRetezec(true);
        this.notifyAll();
    }

    public synchronized double vyberZeZasobniku() {
        double vracenyRetezec = -1;
        while (this.retezec.size() <= 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.out.println("Vyber - InterruptedException");
                this.retezec = null;
                break;
            }
        }
        if (this.retezec.get(0) != null) {
            vracenyRetezec = this.retezec.get(0);
            this.retezec.remove(0);
        }
        setVlozenRetezec(false);
        
        this.notifyAll();
        return vracenyRetezec;
    }
}
