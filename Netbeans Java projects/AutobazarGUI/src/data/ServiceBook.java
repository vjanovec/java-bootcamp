/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Arrays;

/**
 *
 * @author lmasic
 */
public class ServiceBook {
    private final int maxLen = 10;
    private String[] serviceRecords;
    private int count;
    private Car car;
    
    public ServiceBook(Car car) {
        this.car = car;
        this.count = 0;
        serviceRecords = new String[maxLen]; 
        car.setServiceBook(this);
    }
   
    public java.util.List<String> getServiceRecords() {
        
        return Arrays.asList(this.serviceRecords);
    }

    public void addRecord(String record) {
        if (count < maxLen) {
            serviceRecords[count] = record;
            count++;
        }
    }

    public Car getCar() {
        return car;
    }
}
