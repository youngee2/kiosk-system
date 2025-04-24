package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.example.kiosk.Main.isOnOff;

//프로그램 순서 및 흐름 제어를 담당하는 클래스
public class Kiosk {
    static final List<MenuItem> menuList = new ArrayList<>();


    //클래스 생성자를 통해 값을 할당
    Kiosk(String itemName, double itemPrice, String itemInfo){
        menuList.add(new MenuItem(itemName, itemPrice, itemInfo));
    }

    public Kiosk() {

    }


    //등록된 메뉴 출력
        public void start() {
            Scanner sc = new Scanner(System.in);
            do {
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i <= menuList.size() - 1; i++) {
                MenuItem menuItem = menuList.get(i);
                System.out.println((i + 1) + ". " + menuItem.getItemName() + " | W " + menuItem.getItempPrice() + " | " + menuItem.getItemInfo());
                if (i == menuList.size() - 1) {
                    System.out.println("0. 종료  | 종료");
                }
            }
                int orderMenu = sc.nextInt();
                menuSelect(orderMenu);
                //키오스크 프로그램 종료
                if(orderMenu==0){
                    isOnOff=false;
                    System.out.println("프로그램을 종료합니다.");
                }

            }while (isOnOff);

        }

    //선택된 메뉴 출력.
    public void menuSelect(int menuNumber){
        switch (menuNumber){
            case 1:
                System.out.println("선택한 메뉴: shackBurger | W6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
            break;
            case 2:
                System.out.println("선택한 메뉴: SmokeShack | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
            break;
            case 3:
                System.out.println("선택한 메뉴: Cheeseburger | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
            break;
            case 4:
                System.out.println("선택한 메뉴: Hamburger | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
            case 0:
                break;
        }
    }
}
