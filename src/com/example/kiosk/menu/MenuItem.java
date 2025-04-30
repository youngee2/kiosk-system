package com.example.kiosk.menu;

//세부 메뉴 속성을 가지는 클래스
//햄버거의 이름, 가격 설명
// ex)ShackBurger, 6.9, 토마토, 양상추, 쉑소스가 토핑된 치즈버거
// ex) new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거")


public class MenuItem {
    //속성
    private String itemName; //메뉴 이름
    private double itemPrice; //메뉴 가격
    private String itemInfo; //메뉴 설명

//생성자
public MenuItem(String itemName, double itemPrice, String itemInfo){
    this.itemName=itemName;
    this.itemPrice=itemPrice;
    this.itemInfo=itemInfo;
    }

//기능
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItempPrice() {
        return itemPrice;
    }

    public void setItempPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(String itemInfo) {
        this.itemInfo = itemInfo;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
