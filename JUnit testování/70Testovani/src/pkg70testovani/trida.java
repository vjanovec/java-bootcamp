/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg70testovani;

/**
 *
 * @author lmasic
 */
public class trida {
    public static final int MAX_VALUE_LENGTH = 10;

    private String value;

    public trida(String value) {
        setValue(value);
    }


    public void setValue(String newValue) {
        if (newValue == null) throw new IllegalArgumentException("cannot set value to null");
        value = newValue.length() > MAX_VALUE_LENGTH ? newValue.substring(0, MAX_VALUE_LENGTH - 3) + "..." : newValue;
    }

    public String getValue() {
        return value;
    }
}
