/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auta;

/**
 *
 * @author Director itSTEP
 */
class Engine {

    private String type;

    public Engine(String type) {

        this.type = type;
    }

    @Override
    public String toString() {

        return "{" + type + "}";
    }
}
