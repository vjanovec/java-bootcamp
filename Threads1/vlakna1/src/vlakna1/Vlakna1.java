/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlakna1;

/**
 *
 * @author virtuoso
 */
public class Vlakna1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Zasobnik zas = new Zasobnik(); // vytvoření zásobníku
        Producent v = new Producent(zas); // vytvoření a spuštění
        Thread t0 = new Thread(v, "Producent"); // vlákna Producent
        t0.start();
        
        Konzument b1 = new Konzument(zas); // vytvoření a spuštění
        Thread t1 = new Thread(b1, "prvni"); // vlákna Konzument
        t1.start();
        
        try {
            t0.join(); // čekám na dokončení producenta
        } catch (InterruptedException e) {
            System.out.println("Hlavni vlakno - InterruptedException");
        }
        t1.interrupt(); // ukončuji konzumenta
// pomocí interruptu
        System.out.println("Hlavni vlakno - konec");
    }

}
