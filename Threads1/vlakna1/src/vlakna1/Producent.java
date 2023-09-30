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
class Producent implements Runnable {

    Zasobnik zas;

    public Producent(Zasobnik zas) {
        this.zas = zas;
    }

    public void run() {
        for (int i = 1; i <= 20; i++) {
            if (zas.velikost() < 5) {
                double cislo = (Math.random() * 10);
                zas.ulozDoZasobniku(cislo);
                System.out.println("Producent " + Thread.currentThread().getName()
                        + " uložil " + cislo + " poradi: " + i);
            }

        }
    }
}
