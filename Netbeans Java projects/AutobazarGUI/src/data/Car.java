/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author lmasic
 */
public class Car {
    private String znacka;
    private String model;
    private int najeto;
    private double spotreba;
    private double cena;
    public ServiceBook serviceBook;

    public Car() {
    }

    public Car(String znacka, String model, int najeto, double spotreba, double cena) {
        this.znacka = znacka;
        this.model = model;
        this.najeto = najeto;
        this.spotreba = spotreba;
        this.cena = cena;
    }

    public double getCena() {
        return cena;
    }

    public String getZnacka() {
        return znacka;
    }

    public String getModel() {
        return model;
    }

    public int getNajeto() {
        return najeto;
    }

    public double getSpotreba() {
        return spotreba;
    }

    public void setZnacka(String znacka) {
        this.znacka = znacka;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNajeto(int najeto) {
        this.najeto = najeto;
    }

    public void setSpotreba(double spotreba) {
        this.spotreba = spotreba;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return this.znacka+" "+this.model+" "+
                this.najeto+" "+this.spotreba+" "+
                this.cena;
    }
    
    
    public double cenaCesty(int km, double cenaPHM) {
    
        
        return this.spotreba*km/100*cenaPHM;
        
    }
    public void setServiceBook(ServiceBook sb) {
        if (this.serviceBook==null)
            this.serviceBook=sb;
    }

    public ServiceBook getServiceBook() {
        return serviceBook;
    }
    
}
