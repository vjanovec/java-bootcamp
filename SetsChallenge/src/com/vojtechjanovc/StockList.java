package com.vojtechjanovc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StockList {

    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new HashMap<>();
    }
// Method adds new item in stockList
// If StockList already contains StockItem, method increase the item quantity
    public int reserveStock(StockItem item, int quantity) {
        if(list.get(item.getItemName()) != null) {
            if(item.reserveItem(quantity)) {
                System.out.println("Successfully reserved "+quantity+" "+item.getItemName());
                return quantity;
            } else {
                System.out.println("We dont have enough "+item.getItemName());
            }
        } else {
            System.out.println("We dont sell "+item.getItemName());
        }
        return -1;
    }



    public int addStock(StockItem item) {
        if(item != null) {
            StockItem inStock = list.getOrDefault(item.getItemName(), item);
            if(inStock != item) {
                inStock.adjustStock(item.getStockQuantity());
            }
            list.put(item.getItemName(), item);
            return item.getStockQuantity();

        }
        return 0;
    }
// Method that reduce item quantity (stockItemQuantity)

    public int sellStock(StockItem item, int quantity) {
        if(item != null) {
            StockItem inStock = list.get(item.getItemName());
            if((inStock.getStockQuantity() - quantity>0) || (quantity > 0)) {
                int totalPrice = item.getItemPrice()*quantity;
                System.out.println("Successfully sold "+quantity+" "+item.getItemName()+ "for "+totalPrice);
                return quantity;
            }
            System.out.println("Error, cant sell more then available");
        } else {
            System.out.println("Parameter is null");
        }
        return 0;
    }

    public StockItem getItem(String itemName) {
        return list.get(itemName);
    }

    public Map<String, StockItem> getList() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String output = "=======================\nStockList\n=======================\n";
        for(Map.Entry<String, StockItem> entry : list.entrySet() ) {
            //output += ("%s : price : %d, There are %d in stock, Total cost %d", entry.getKey(), )
            output += (entry.getKey() + " : price : "+entry.getValue().getItemPrice()+" There are "+entry.getValue().getStockQuantity())+" in stock,"+" Total cost : "+entry.getValue().getTotalCost()+"\n";
        }
        return output;
    }
}
