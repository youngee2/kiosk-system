package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

//프로그램 MenuItem 클래스를 관리하는 클래스
//ex) 버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 MenuItem을 포함합니다.
public class Menu {

    private String categoryName;
    private List<MenuItem> menuList; //카테고리에 맞는 메뉴 아이템을 저장할 리스트 생성


    Menu(String category) {
        this.categoryName = category; //카테고리 지정
        this.menuList = new ArrayList<>(); 
    }


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public List<MenuItem> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuItem> menuList) {
        this.menuList = menuList;
    }

    //해당 카테고리의 맞는 아이템메뉴 추가.
    public void addItem(MenuItem item){
        menuList.add(item);
    }



}