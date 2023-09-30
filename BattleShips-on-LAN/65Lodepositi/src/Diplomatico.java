/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Director itSTEP
 */
public class Diplomatico extends Ship{
    
    public Diplomatico(String name) {
        super("Diplomatico:"+name);
    }
    public Diplomatico(String name,Flotile flotile) {
        super("Diplomatico:"+name,flotile);
        this.hp=2;
        this.maxHp=2;
    }
    
}
