package com.example.kiosk.cart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    //장바구니
    private List<CartItem> cartList;
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
    public void show() {
        // for (CartItem item : getCartList())
        //리스트를 가져와서 리스트 항목을 하나씩 꺼내면서 해당 항목에 대해 출력
        getCartList().forEach(cartItem ->
                System.out.println(cartItem.getItemName() + " | W " + cartItem.getPrice() + " | " + cartItem.getQuantity()));
        }

    // 입력받은 메뉴를 장바구니에서 필터링 후 제거
    public void selectRemove(String selectMenu){
        getCartList() //장바구니 목록을 가져와서
                .stream() //스트림 시작
                .filter(cartItem -> cartItem.getItemName().contains(selectMenu)) //장바구니 목록 중 메뉴이름에 입력받은 메뉴가 포함되는 것만 필터링
                .findFirst() //조건에 해당하는 첫 번째 항목만
                .ifPresent(cartItem-> cartList.remove(cartItem)); //장바구니에서 제거

    }


    //장바구니 초기화
    public void cartReset(){
        cartList.clear();
    }



    public List<CartItem> getCartList() {
        return cartList;
    }


}
