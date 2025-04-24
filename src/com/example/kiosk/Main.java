package com.example.kiosk;

import java.util.Scanner;

//프로그램 시작점
public class Main{
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        boolean isOnOff=true;
        Scanner sc = new Scanner(System.in);
        do {
            String menu = """
                    
                    [ SHAKESHACK MENU ]
                    1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
                    2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
                    3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
                    4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
                    0. 종료      | 종료
                    """;
            System.out.println(menu);
            int orderMenu = sc.nextInt();
            kiosk.menuSelect(orderMenu);

            //키오스크 프로그램 종료
            if(orderMenu==0){
                isOnOff=false;
                System.out.println("프로그램을 종료합니다.");
            }
        }while (isOnOff);
    }
}
