/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg35autobazar;

import data.Car;
import data.ServiceBook;

/**
 *
 * @author lmasic
 */
public class Autobazar {

    private int pocet = 0;
    private final int maxPocet = 10;
    private Car[] auta = new Car[maxPocet];
    private ServiceBook[] serknihy = new ServiceBook[maxPocet];
    String nazev;

    public Autobazar(String nazev) {

        this.nazev = nazev;
    }
    
    public void addCar(Car car) {
    
     if (pocet < maxPocet) {
            this.auta[pocet] = car;
            
            if (car.serviceBook==null) {
                ServiceBook sb1 = new ServiceBook(car);
                
                
            }
            this.serknihy[pocet]=car.serviceBook;
                    
            this.pocet++;
        }
    }
    
    /*
    
    
    addCar(Car car) - ověřit, že tam je sb, jinak přidat
    removeCar(int index)
    removeCar(Car car)
    getCar(int index)
    searchFulltextCar(String txt)
    
    
    */
    
    
}
