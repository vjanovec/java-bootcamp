/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Director itSTEP
 */
public final class Flotile {

    private ArrayList<Ship> ships = new ArrayList<Ship>();
    String name = null;
    private ArrayList<Dock> docks = new ArrayList<Dock>();
  

    private int numberAliveShips = 0;

    private int numberAliveRescuShips = 0;
    private int numberAliveDiplomaticoShips = 0;
    private int numberAliveCuiserShips = 0;

    private int countOfRescuShips = 0;
    private int countOfDiplomaticoShips = 0;
    private int countOfCuiserShips = 0;

    Flotile(String name) throws Exception {
       
        this(name,6);
     
    }
    
    Flotile(String name, int count) throws Exception {
         this(name,count,1);
        

    }

    Flotile(String name, int count, int countDocs) throws Exception {
        this.name = name;
        this.makeShips(count);
        this.numberAliveShips = count;
        
        for (int i = 0; i < countDocs; i++) {
            this.docks.add(new Dock());
        }

    }

    protected void makeShips(int count) throws Exception {

        if (count < 3) {
            throw new Exception("Minimum of ships is 3!");

        }
        this.countOfDiplomaticoShips = count / 5 + 1;
        this.numberAliveDiplomaticoShips = countOfDiplomaticoShips;

        this.countOfRescuShips = (count - this.countOfDiplomaticoShips) / 5 + 1;
        this.numberAliveRescuShips = this.countOfRescuShips;

        this.numberAliveCuiserShips = count - this.countOfDiplomaticoShips - this.countOfRescuShips;
        this.countOfCuiserShips = this.numberAliveRescuShips;

        for (int i = 0; i < this.countOfDiplomaticoShips; i++) {
            this.ships.add(new Diplomatico("Diplomatico" + String.valueOf(i),this));
        }

        for (int i = 0; i < this.countOfRescuShips; i++) {
            this.ships.add(new RecueShip("RescuShip" + String.valueOf(i),this));
        }
        for (int i = 0; i < this.countOfCuiserShips; i++) {
            this.ships.add(new Cruiser("Cuiser" + String.valueOf(i),this));
        }

    }

    public ArrayList<Dock> getAllDock() {

        return docks;
    }

    public Ship getRandomAliveShip() throws Exception {
        if (this.numberAliveShips < 1) {
            throw new Exception("Flotile is sank!");
        }

        if (this.numberAliveShips == 1) {

            for (int i = 0; i < this.ships.size(); i++) {
                if (this.ships.get(i).isAlive()) {
                    return this.ships.get(i);
                }
            }

        }
        Random random = new Random();
        int randonInt = 0;
        while (true) {

            randonInt = random.nextInt(this.numberAliveShips);

            if (this.ships.get(randonInt).isAlive()) {
                return this.ships.get(randonInt);
            }

        }

    }
   

    public Ship getRandomAliveRescuShip() throws Exception {

        if (this.numberAliveRescuShips < 1) {
            throw new Exception("Flotile is sank!");
        }

        if (this.numberAliveRescuShips == 1) {

            for (int i = 0; i < this.ships.size(); i++) {
                if (this.ships.get(i).isAlive()
                        && this.ships.get(i) instanceof RecueShip) {
                    return this.ships.get(i);
                }
            }

        }
        Random random = new Random();
        int randonInt = 0;
        while (true) {

            randonInt = random.nextInt(this.numberAliveRescuShips);

            if (this.ships.get(randonInt).isAlive()
                    && this.ships.get(randonInt) instanceof RecueShip) {
                return this.ships.get(randonInt);
            }

        }
    }
    /*
    public Ship getRandomAliveDiplomaticoShip() {
    }

    public Ship getRandomAliveCuiserShip() {
    }
*/
    public boolean IsSunken() {
        
        return true;//TODO:IsSunken!!!!
    }
     
}
