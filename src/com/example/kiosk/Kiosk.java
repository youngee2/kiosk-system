package com.example.kiosk;

//프로그램 순서 및 흐름 제어를 담당하는 클래스
public class Kiosk {

    public void menuSelect(int menuNumber){

        switch (menuNumber){
            case 1:
                System.out.println("shackBurger | W6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
            break;
            case 2:
                System.out.println("SmokeShack | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
            break;
            case 3:
                System.out.println("Cheeseburger | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
            break;
            case 4:
                System.out.println("Hamburger | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
            case 0:
                break;
        }
    }
}
