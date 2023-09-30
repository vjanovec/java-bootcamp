/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vojtechjanovec.pexeso;

/**
 *
 * @author student
 */
public class Tile {
    private final int content;

    public Tile(int content) {
        this.content = content;
    }

    public int getContent() {
        return content;
    }

    public Tile clone() {
        return new Tile(this.content);
    }
    
    
}
