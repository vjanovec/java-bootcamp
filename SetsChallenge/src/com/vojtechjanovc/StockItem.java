package com.vojtechjanovc;

public class StockItem {

    private String itemName;
    private int itemPrice;
    private int stockQuantity;
    private int reserved;

    public StockItem(String itemName, int itemPrice, int stockQuantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.stockQuantity = stockQuantity;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public int getTotalCost() {
        return itemPrice*stockQuantity;
    }

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    public boolean reserveItem(int quantity) {
        if(quantity>0 && quantity<stockQuantity) {
            adjustStock(-quantity);
            reserved+= quantity;
            return true;
        }
        return false;
    }

    public int adjustStock(int quantity) {
        if(((stockQuantity - quantity)>0) || (stockQuantity + quantity)>0) {
            stockQuantity+=quantity;
        }
        return stockQuantity;
    }



    @Override
    public String toString() {
        return "StockItem{" +
                "itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", stockQuantity=" + stockQuantity +
                '}';
    }
}
