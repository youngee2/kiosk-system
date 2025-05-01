package com.example.kiosk.cart;


public class CartItem {
    private String itemName;
    private int quantity;
    private double price;


    //생성자
    public CartItem(String itemName, int quantity, double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    //장바구니에 같은 제품을 담으면 기존 수량에 더해지는 메서드
    public void addQuantity() {
        this.quantity++;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }


}
