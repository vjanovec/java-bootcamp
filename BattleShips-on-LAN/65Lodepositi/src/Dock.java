/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Director itSTEP
 */
public class Dock {

    private Ship ship;

    public Dock() {

    }

    public void loadShip(Ship ship) {
        this.ship = ship;

    }

    public void unLoadShip() {
        this.ship = null;

    }

    public void repairShip() {
        if (ship!=null) {
            try {
                ship.increeseHp(this);
            } catch (Exception ex) {
                Logger.getLogger(Dock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Ship getShip() {

        return this.ship;

    }

}
