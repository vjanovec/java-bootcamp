/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lode;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Director itSTEP
 */
public class Lode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sea sea = new Sea(2);
          (new Simulator(sea)).play();
/*
        try {
            Flotile cppp = new Flotile("CCCP");
            System.out.println("---");
        } catch (Exception ex) {
            Logger.getLogger(Lode.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Flotile cr = new Flotile("ČR", 12);
            System.out.println("---");
        } catch (Exception ex) {
            Logger.getLogger(Lode.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        */

        Diplomatico santa_maria = new Diplomatico("Santa Maria");
            
            //santa_maria.getHp();
            Cruiser kriznik = new Cruiser("Potěnkin");
            //kriznik.getHp();
            
            kriznik.dealDamage(santa_maria);
            
           
            Cruiser kriznik2 = new Cruiser("Potěnkin II");
            
            kriznik.dealDamage(kriznik2);
            
            System.out.println(kriznik2.getHp());
            
            Dock dock1 = new Dock();
            
            dock1.receiveShip(santa_maria);
            dock1.repairShip();
            dock1.releaseShip();
            
            System.out.println("santa_maria: "+santa_maria.getHp());
            
            try {
            Flotile cccp = new Flotile("cccp",10);
            } catch (Exception ex) {
            Logger.getLogger(Lode.class.getName()).log(Level.SEVERE, null, ex);
            }
         
    }

}
