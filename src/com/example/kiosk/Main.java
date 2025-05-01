package com.example.kiosk;

import com.example.kiosk.menu.Menu;
import com.example.kiosk.menu.MenuItem;

import java.util.ArrayList;
import java.util.List;

//프로그램 시작점
public class Main {

    //키오스크 전원
    static boolean isOnOff = true;

    public static void main(String[] args) {
        //햄버거 메뉴 카테고리
        Menu burgers = new Menu("BURGERS");
        //디저트에 해당하는 메뉴 추가
        burgers.addItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.addItem(new MenuItem("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.addItem(new MenuItem("HamBurger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        //음료 메뉴 카테고리
        Menu drinks = new Menu("DRINKS");
        //음료에 해당하는 메뉴 추가
        drinks.addItem(new MenuItem("제로 콜라", 1.8, "시원한 제로 콜라"));
        drinks.addItem(new MenuItem("제로 사이다", 1.8, "시원한 제로 사이다"));

        //디저트 메뉴 카테고리
        Menu desserts = new Menu("DESSERTS");
        //디저트에 해당하는 메뉴 추가
        desserts.addItem(new MenuItem("아이스크림", 2.5, "맛있는 아이스크림"));
        desserts.addItem(new MenuItem("치즈볼", 6.0, "쫄깃 치즈볼"));
        desserts.addItem(new MenuItem("치즈스틱", 3.5, "쭈욱 늘어나는 치즈스틱"));


        List<Menu> menuList = new ArrayList<>();

        menuList.add(burgers); //카테고리에 버거 추가
        menuList.add(drinks); //카테고리에 음료 추가
        menuList.add(desserts); //카테고리에 디저트 추가

        //Kiosk 프로그램 시작하는 메서드 실행
        Kiosk kiosk = new Kiosk(menuList); //kiosk 객체를 생성하면서 menuList(카테고리와 카테고리에 해당되는 음식이 담긴 리스트를 kiosk 생성자로 전달)
        kiosk.start();

    }
}