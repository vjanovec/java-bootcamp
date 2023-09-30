/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lode;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Director itSTEP
 */
public class Simulator {

    private Sea sea;
    private int round = 0;

    Simulator(Sea sea) {

        this.sea = sea;
    }

    public void round() {
        this.round++;
        this.repairAllShip();
        try {
            this.fight();
        } catch (Exception ex) {
            Logger.getLogger(Simulator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void play() {

        while (!this.sea.isWinner()) {
            this.round();
            System.out.println("Round: " + this.round);

        }

    }

    private void repairAllShip() {

        for (Flotile flotile : this.sea.getAllFlotiles()) {

            for (Dock dock : flotile.getAllDock()) {
                dock.repairShip();

            }
        }
    }

    private void fight() throws Exception {

        if (this.sea.isWinner()) {
            throw new Exception("We have winner");
        }
        //****//
        Random rnd = new Random();

        Flotile f1 = this.sea.getRandomFlotile();
        Flotile f2 = f1;

        while (f2 == f1) {

            f2 = this.sea.getRandomFlotile();
        }
        //****//

        Ship s1 = f1.getRandomAliveShip();
        Ship s2 = f2.getRandomAliveShip();

        if (s1 instanceof Cruiser) {

            ((Cruiser) s1).dealDamage(s2);
        }
        if (s2.isAlive()) {
            if (s2 instanceof Cruiser) {

                ((Cruiser) s2).dealDamage(s1);
                if (!s1.isAlive())
                    sea.moveShipToGraveYard(s1);
            }

        }else {//move to graveyard
            
            sea.moveShipToGraveYard(s2);
        
        
        }

    }
}
