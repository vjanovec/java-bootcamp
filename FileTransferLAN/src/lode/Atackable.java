/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lode;

/**
 *
 * @author lmasic
 */
public interface Atackable {
    int damage=1;
    public void dealDamage(Ship ship);
    
    public int getDamage();
}
