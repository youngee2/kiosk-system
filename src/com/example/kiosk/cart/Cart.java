package com.example.kiosk.cart;

import com.example.price.PriceItem;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    //장바구니
    List<CartItem> cartList;
    PriceItem priceItem;
    public Cart() {
        this.cartList = new ArrayList<>();
    }

    //장바구니 추가
    public void add(String itemName, int quantity, double itemPrice) {
        for (CartItem item : cartList) {
            if (item.getItemName().equals(itemName)) {
                item.addQuantity();
                return;
            }
        }
        cartList.add(new CartItem(itemName, quantity, itemPrice));
        System.out.println(itemName + "이 장바구니에 추가되었습니다.");
    }


    //장바구니 조회
    public void show(){
        for(CartItem item: getCartList()){
            System.out.println(item.getItemName() + " | W " + item.getPrice() + " | " + item.getQuantity());
        }
    }



    public List<CartItem> getCartList() {
        return cartList;
    }
}
