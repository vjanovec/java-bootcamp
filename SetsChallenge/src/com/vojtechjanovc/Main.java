package com.vojtechjanovc;

public class Main {
    static StockList myList = new StockList();

    public static void main(String[] args) {

        StockItem eggs = new StockItem("Eggs", 5, 60);
        StockItem bread = new StockItem("Bread", 20, 8);
        StockItem milk = new StockItem("Milk", 30, 20);


        myList.addStock(eggs);
        myList.addStock(bread);
        myList.addStock(milk);
        System.out.println(myList);
        Basket myBasket = new Basket();
        sellItem(myBasket, "Eggs", 10);
        sellItem(myBasket, "Bread", 2);
        sellItem(myBasket, "Milk", 5);
        System.out.println(myList);
        System.out.println(myBasket);

    }

    public static void sellItem(Basket basket, String itemName, int quantity) {
        StockItem item = myList.getItem(itemName);
        if (item != null) {
            if (item.getStockQuantity() > quantity) {
                if(myList.reserveStock(item, quantity) > 0) {
                    basket.addToBasket(item, quantity);
                }
            } else {
                System.out.println("We dont have enough " + itemName);
            }
        } else {
            System.out.println("We dont sell " + itemName + ".");
        }
    }


}
