package com.example.kiosk;

import java.util.List;
import java.util.Scanner;

import static com.example.kiosk.Main.isOnOff;

//프로그램 순서 및 흐름 제어를 담당하는 클래스
public class Kiosk {
    Scanner sc = new Scanner(System.in);
    private List<Menu>menuList;

    //클래스 생성자를 통해 값을 할당
    Kiosk(List<Menu> menuList) {
        this.menuList=menuList;
    }

    //등록된 메뉴 출력
    public void start() {
        while (isOnOff) {
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menuList.size(); i++) {
                System.out.println((i + 1) + ". " + menuList.get(i).getCategoryName());
            }
            System.out.println("0. 종료");


            String input = sc.next();
            try {
                int orderMenu = Integer.parseInt(input);
                //숫자인데 메뉴에 없는 숫자를 선택했을 때 출력.
                if (orderMenu == 0) {
                    System.out.println("프로그램 종료");
                    isOnOff = false; //종료
                } else if (orderMenu > 0 && orderMenu <= menuList.size()) {
                    printCategoryItems(menuList.get(orderMenu - 1));
                } else {
                    System.out.println("처음으로 돌아갑니다. 메뉴를 선택해주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
            }

        }

    }
    //해당 카테고리에 포함되는 메뉴 아이템들 출력하는 메서드
    private void printCategoryItems(Menu menu) {
        System.out.println("[ " + menu.getCategoryName() + " ]");
        List<MenuItem> items = menu.getMenuList();
        for (int i = 0; i < items.size(); i++) {
            MenuItem item = items.get(i);
            System.out.println((i + 1) + ". " + item.getItemName() + " | W " + item.getItempPrice() + " | " + item.getItemInfo());
        }
        System.out.println("0. 뒤로가기");

        String selectOrder = sc.next();
        try {
            int choice = Integer.parseInt(selectOrder);

            if (choice == 0) {
                return; //현재 메서드 종료
            } else if (choice > 0 && choice <= items.size()) {
                MenuItem selectedItem = items.get(choice - 1);
                System.out.println("선택한 메뉴: " + selectedItem.getItemName() + " | W " + selectedItem.getItempPrice() + " | " + selectedItem.getItemInfo());
            } else {
                System.out.println("존재하지 않는 메뉴입니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요.");
        }
    }


    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }


}