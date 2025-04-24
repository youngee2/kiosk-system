package com.example.kiosk;

//세부 메뉴 속성을 가지는 클래스
//햄버거의 이름, 가격 설명
// ex)ShackBurger, 6.9, 토마토, 양상추, 쉑소스가 토핑된 치즈버거
// ex) new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거")


public class MenuItem {
    //속성
    private String itemName; //메뉴 이름
    private double itempPrice; //메뉴 가격
    private String itemInfo; //메뉴 설명

public MenuItem(String itemName, double itemPrice, String itemInfo){
    this.itemName=itemName;
    this.itempPrice=itemPrice;
    this.itemInfo=itemInfo;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItempPrice() {
        return itempPrice;
    }

    public void setItempPrice(double itempPrice) {
        this.itempPrice = itempPrice;
    }

    public String getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(String itemInfo) {
        this.itemInfo = itemInfo;
    }



}
