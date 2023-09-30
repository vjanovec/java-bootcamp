/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Director itSTEP
 */
public abstract class Ship {

    protected int hp = 1;
    protected String name = "";
    protected int maxHp = 1;
    protected Flotile flotile;

      public Ship(String name) {

        this.name = name;
      

    }
      
    public Ship(String name,Flotile flotile) {

        //this.hp = hp;
        this.name = name;
        this.flotile=flotile;

    }

    public int getMaxHp() {

        return this.maxHp;

    }
    public int getHp() {

        return this.hp;

    }

    public void decreeseHp(Atackable atc) {

        
        this.hp -= atc.getDamage();
        if (this.hp < 0) {
            this.hp = 0;
        }

    }

    public void increeseHp(Dock dock) throws Exception {

        if (this.hp >= this.maxHp) {
            throw new Exception("You reach max HP!");
        }

        if (dock.getShip() == this) {
            this.hp++;
        } else {
            throw new Exception("Call from dock only!");

        }
    }

    public boolean isAlive() {
//TODO: pokud je loď v doku, tak je opravované a tedy není živá.
        if (this.hp > 0) {
            return true;
        } else {
            return false;
        }
    }

}
