package com.example.kiosk.price;

public class PriceItem {
    private double totalPrice;



    //가격 더하기
    public void totalPrice(double price){
       this.totalPrice+=price;
    }


    //총 가격 출력
    public void printPrice(){
        System.out.println("[ Total ]");
        System.out.println("W "+totalPrice);
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
