package com.vojtechjanovec;

public class Customer {
    private int customerId;
    private int basket;

    public Customer(int customerId, int basket) {
        this.customerId = customerId;
        this.basket = basket;
    }

    public int getBasket() {
        return basket;
    }

    public int getCustomerId() {
        return customerId;
    }
}
