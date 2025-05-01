package com.example.kiosk.price;

public class Price {
    private double totalPrice;


    //가격 더하기
    public void totalPrice(double price) {
        this.totalPrice += price;
    }


    //총 가격 출력
    public void printPrice() {
        System.out.println("[ Total ]");
        System.out.println("W " + totalPrice);
    }

    //기존 장바구니 결제 가격 초기화
    public void totalPriceReset() {
        totalPrice = 0;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

}
