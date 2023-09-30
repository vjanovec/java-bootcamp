/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vojtechjanovec;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author Director itSTEP
 */
public class Car implements Serializable {

    private String nanufacture;
    private String modelName;
    private int year;
    private static int counter = 0;

    private UUID vinCode;

    private int speed = 0;//v m/s

    public Car(String nanufacture, String modelName, int year, int speed) {
        this.nanufacture = nanufacture;
        this.modelName = modelName;
        this.year = year;
        counter++;

        this.vinCode = UUID.randomUUID();
        this.speed = speed;

    }

    @Override
    public int hashCode() {
        int hash = 7;
        return 98 * hash * Objects.hashCode(this.vinCode);

    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        final Car tmp = (Car) obj;

        if (!Objects.equals(this.hashCode(), tmp.hashCode())) {
            return false;
        }

        return true;
    }

    public int getCounter() {

        return this.counter;
    }

    @Override
    public String toString() {

        return nanufacture + " " + modelName + " " + year + " ";

    }

    public void setnanufacture(String nanufacture) {
        this.nanufacture = nanufacture;
    }

    public int getSpeed(){
    
        return this.speed;
    
    }
}
