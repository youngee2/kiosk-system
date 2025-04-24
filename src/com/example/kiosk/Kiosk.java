package com.example.kiosk;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.example.kiosk.Main.isOnOff;

//프로그램 순서 및 흐름 제어를 담당하는 클래스
public class Kiosk {
    static final List<MenuItem> menuList = new ArrayList<>();
    int orderMenu;

    //클래스 생성자를 통해 값을 할당
    Kiosk(String itemName, double itemPrice, String itemInfo){
        menuList.add(new MenuItem(itemName, itemPrice, itemInfo));
    }

    public Kiosk() {

    }


    //등록된 메뉴 출력
        public void start() {
            Scanner sc = new Scanner(System.in);

            while(isOnOff) {
                System.out.println("[ SHAKESHACK MENU ]");
                for (int i = 0; i <= menuList.size() - 1; i++) {
                    MenuItem menuItem = menuList.get(i);
                    System.out.println((i + 1) + ". " + menuItem.getItemName() + " | W " + menuItem.getItempPrice() + " | " + menuItem.getItemInfo());
                    if (i == menuList.size() - 1) {
                        System.out.println("0. 뒤로가기  | 뒤로가기");
                    }
                }
                //nextInt()를 사용하면 잘못된 입력이 버퍼에 남아 있어서 무한 반복
                String input=sc.next();
                try {
                    int orderMenu = Integer.parseInt(input);
                    //숫자인데 메뉴에 없는 숫자를 선택했을 때 출력.
                    if (orderMenu>menuList.size()) {
                        //메뉴 갯수보다 같거나 적으면서 0이 아니면 해당되는 메뉴 로직 실행.
                        System.out.println("존재하지 않는 메뉴입니다.");

                    } else if(orderMenu!=0){
                        menuSelect(orderMenu);
                        //0을 입력하면 프로그램이 뒤로가게 작성
                    
                    }else{
                        System.out.println("처음으로 돌아갑니다. 메뉴를 선택해주세요.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("숫자만 입력해주세요.");
                }


            }

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
