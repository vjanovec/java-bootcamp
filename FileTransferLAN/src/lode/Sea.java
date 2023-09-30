/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lode;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Director itSTEP
 */
public class Sea {
    
    private ArrayList<Ship> graveYard = new ArrayList<Ship>();
    private ArrayList<Flotile> flotiles = new ArrayList<Flotile>();
    
    Sea(int countFlotiles) {
        
        for (int i = 0; i < countFlotiles; i++) {
            try {
                this.flotiles.add(new Flotile("Flotile" + i));
            } catch (Exception ex) {
                Logger.getLogger(Sea.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public ArrayList<Flotile> getAllFlotiles() {
        
        return this.flotiles;
    }
    
    public void moveShipToGraveYard(Ship ship) throws Exception {
        
        if (this.graveYard.indexOf(ship) > -1) {
            
            this.graveYard.add(ship);
        } else {
            throw new Exception("Ship has been in grayYard");

        }
    }

    public void removeShipFromGraveYard(Ship ship) {
        
        this.graveYard.remove(ship);//TODO add exception
        
    }

    public Flotile getRandomFlotile() {
        //TODO pokud je flotil méně než 3 - negenerovat, ale najít.
        Random rnd = new Random();
        
        return this.flotiles.get(rnd.nextInt(this.flotiles.size()));
    }
    
    public boolean isWinner() {
        int countWinners = 0;
        for (Flotile flotile : this.flotiles) {
            
            if (!flotile.IsSunken()) {
                countWinners++;
            }
            if (countWinners > 1) {
                return false;
            }
        }
        return true;
    }
    
}
