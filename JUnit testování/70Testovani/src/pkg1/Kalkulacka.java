/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

/**
 *
 * @author lmasic
 */
// https://www.itnetwork.cz/java/testovani/testovani-v-jave-prvni-unit-test-v-junit
public class Kalkulacka {
   
    /**
     * Sečte 2 čísla
     * @param a První číslo
     * @param b Druhé číslo
     * @return Součet 2 čísel
     */
    public double secti(double a, double b) {
        return a + b;
    }
    
    /**
     * Odečte 2 čísla
     * @param a První číslo
     * @param b Druhé číslo
     * @return Rozdíl 2 čísel
     */
    public double odecti(double a, double b) {
        return a - b;
    }
    
    /**
     * Vynásobí 2 čísla
     * @param a První číslo
     * @param b Druhé číslo
     * @return Součin 2 čísel
     */
    public double vynasob(double a, double b) {
        return a * b;
    }
    
    /**
     * Vydělí 2 čísla
     * @param a První číslo
     * @param b Druhé číslo
     * @return Podíl 2 čísel
     */
    public double vydel(double a, double b) {
        if (b == 0)
            throw new IllegalArgumentException("Nelze dělit nulou!");
        return a / b;
    }
    
    public int vydel(int a, int b) {
        if (b == 0)
            throw new IllegalArgumentException("Nelze dělit nulou!");
        return a / b;
    }
    
}

