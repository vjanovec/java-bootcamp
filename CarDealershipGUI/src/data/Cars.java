package data;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lmasic
 */
public final class Cars {
     static ArrayList<Car> carsList = new ArrayList<>();
       
     public static void init () {
     
     
       carsList.add(new Car("vw","passat",250011,8.5,50000));
       carsList.add(new Car("Škoda","octavia",11,8.5,500000));
       carsList.add(new Car("Škoda","fobia",11,9.5,250000));
     
       carsList.add(new Car("Škoda","fobia",11,9.5,250000));
     } 
     
     public static ArrayList<Car> getCarsList() {
     
     return carsList;
     }
}
