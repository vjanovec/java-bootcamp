package cz.matejkripner;

/**
 * @author Matìj Kripner <kripnermatej@gmail.com>
 * @version 1.0
 */
public class Container {

    public static final int MAX_VALUE_LENGTH = 10;

    private String value;

    public Container(String value) {
        if (value == null) throw new IllegalArgumentException("cannot set value to null");
        this.value = value;
    }

    public void setValue(String newValue) {
        if (newValue == null) throw new IllegalArgumentException("cannot set value to null");
        value = newValue.length() > MAX_VALUE_LENGTH ? newValue.substring(0, MAX_VALUE_LENGTH - 3) + "..." : newValue;
    }

    public String getValue() {
        return value;
    }
}
