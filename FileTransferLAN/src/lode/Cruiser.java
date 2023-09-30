/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lode;

/**
 *
 * @author Director itSTEP
 */
public class Cruiser extends Ship implements Atackable{
    protected int damage=2;
    
    public Cruiser(String name) {
        super(name);
    }
    public Cruiser(String name,Flotile flotile) {
        super(name,flotile);
        super.hp=3;
        this.maxHp=3;
                
        
        
    }
    
    public void dealDamage(Ship ship) {
        
        if (ship==this) return;
        
        ship.decreeseHp(this);
    }
    
    public int getDamage() {
    
        return this.damage;
    }
    
    
}
