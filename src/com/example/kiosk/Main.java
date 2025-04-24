package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.example.kiosk.Kiosk.menuList;

//프로그램 시작점
public class Main{
    static boolean isOnOff=true;
    public static void main(String[] args) {

        //Kiosk 객체 생성하고 사용하는 main함수에서 객체를 생성할 때 값 넘겨줌.
        Kiosk ShackBurger = new Kiosk("ShackBurger",6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        Kiosk SmokeShack = new Kiosk("SmokeShack",8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        Kiosk CheeseBurger = new Kiosk("CheeseBurger",6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        Kiosk HamBurger = new Kiosk("HamBurger",5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        //Kiosk 프로그램 시작하는 메서드 실행
        new Kiosk().start();

        }
}