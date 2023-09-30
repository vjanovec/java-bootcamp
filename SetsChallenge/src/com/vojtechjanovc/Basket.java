package com.vojtechjanovc;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;


public class Basket {

    private Map<StockItem, Integer> basket;

    public Basket() {
        basket = new LinkedHashMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if (item != null) {
            if (basket.containsKey(item)) {
                int inBasket = basket.get(item);
                basket.put(item, (inBasket + quantity));
                return inBasket + quantity;
            } else {
                basket.put(item, quantity);
                return quantity;
            }
        }
        return -1;
    }

    public Map<StockItem, Integer> getBasket() {
        return Collections.unmodifiableMap(basket);
    }

    @Override
    public String toString() {
        String output = "=======================\nBasket\n=======================\n";
        for (Map.Entry<StockItem, Integer> entry : basket.entrySet()) {
            output += (entry.getKey().getItemName() + " : price : " + entry.getKey().getItemPrice() + " There are " + entry.getValue()) + " in basket," + " Total cost : " + entry.getKey().getItemPrice() * entry.getValue() + "\n";
        }
        return output;
    }
}
