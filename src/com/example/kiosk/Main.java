package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//프로그램 시작점
public class Main{
    static final List<MenuItem> menuList = new ArrayList<>();
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();

        menuList.add(new MenuItem("ShackBurger",6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem("SmokeShack",8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem("CheeseBurger",6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuList.add(new MenuItem("HamBurger",5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        boolean isOnOff=true;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("[ SHAKESHACK MENU ]");
            for(int i=0; i<=menuList.size()-1; i++){
                MenuItem menuItem = menuList.get(i);
                System.out.println((i+1)+". "+menuItem.getItemName()+" | W "+menuItem.getItempPrice()+" | "+menuItem.getItemInfo());
            if(i==menuList.size()-1){
                System.out.println("0. 종료  | 종료");
            }
            }


            int orderMenu = sc.nextInt();
            kiosk.menuSelect(orderMenu);

            //키오스크 프로그램 종료
            if(orderMenu==0){
                isOnOff=false;
                System.out.println("프로그램을 종료합니다.");
            }

        }while (isOnOff);


        }
    public void menuPrint(){

}

}
