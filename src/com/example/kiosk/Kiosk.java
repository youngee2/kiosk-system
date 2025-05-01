package com.example.kiosk;

import com.example.kiosk.cart.Cart;
import com.example.kiosk.menu.Menu;
import com.example.kiosk.menu.MenuItem;
import com.example.kiosk.price.Price;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.example.kiosk.Main.isOnOff;
import static com.example.kiosk.discount.UserDiscountType.discountSelect;
import static java.awt.SystemColor.menu;

//프로그램 순서 및 흐름 제어를 담당하는 클래스
public class Kiosk {
    Scanner sc = new Scanner(System.in);
    private List<Menu> menuList;
    private Cart cart;
    private Price price;


    //클래스 생성자를 통해 값을 할당
    Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
        this.cart = new Cart();
        this.price = new Price();
    }

    //등록된 메뉴 출력
    public void start() {
        while (isOnOff) {
            int orderMenu = 0;
            //메인메뉴 출력하는 메서드
            printMainMenu();
            //장바구니에 상품이 담겨있는 경우에만 출력.
            if (!cart.getCartList().isEmpty()) {
                System.out.println(" [ ORDER MENU ]");
                System.out.println((menuList.size() + 1) + ". Orders    | 장바구니를 확인 후 주문합니다.");
                System.out.println((menuList.size() + 2) + ". Cancel    | 진행중인 주문을 취소합니다.");
            }

            String input = sc.next();
            
            try {
                orderMenu = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                continue;
            }
            if (orderMenu == 0) {
                System.out.println("프로그램 종료");
                isOnOff = false; //종료
            } else if (orderMenu > 0 && orderMenu <= menuList.size()) { 
                printCategoryItems(menuList.get(orderMenu - 1));
            } else if (orderMenu == menuList.size() + 1) {
                System.out.println("아래와 같이 주문 하시겠습니까?");
                System.out.println("[ Orders ]");
                cart.show();
                price.printPrice();

                System.out.println("1. 주문        2. 메뉴판");
                String inputStr = sc.next();
                int discounntSelectNum;
                try {
                    discounntSelectNum = Integer.parseInt(inputStr);
                    if (discounntSelectNum == 1) { //주문을 선택하면 할인정보 출력
                        String discountInfomsg = """
                                할인 정보를 입력해주세요.
                                1. 국가유공자 : 10%
                                2. 군인 : 5%
                                3. 학생 : 3%
                                4. 일반 : 0%
                                """;
                        System.out.println(discountInfomsg);

                        inputStr = sc.next(); //재사용
                        double result = 0;

                        try { //할인 정보가 선택되면 거기에 맞는 할인율을 계산해서 출력하고 장바구니 초기화.
                            result = discountSelect(Integer.parseInt(inputStr)).printResult(price.getTotalPrice());
                        } catch (InputMismatchException e) {
                            System.out.println("숫자만 입력해주세요.");
                        }
                        System.out.printf("주문이 완료되었습니다. 금액은 W %.2f입니다. \n", result);
                        cart.cartReset();
                        price.totalPriceReset();

                        //1번이 아닌 2번 메뉴판을 선택하는 경우나 잘못된 번호를 입력하는 경우에 처음으로 돌아감.
                    } else if (discounntSelectNum == 2) {
                        System.out.println("처음으로 돌아갑니다.");
                    } else { 
                        System.out.println("잘못된 번호입니다. 처음으로 돌아갑니다.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("숫자만 입력해주세요. 처음으로 돌아갑니다. 다시 결제해주세요.");
                    continue;

                }
            }
        }


    }


    //해당 카테고리에 포함되는 메뉴 아이템들 출력하는 메서드
    private void printCategoryItems(Menu menu) {
        int choice = 0;
        int cartAdd;
        String inputCartAdd;

        System.out.println("[ " + menu.getCategoryName() + " ]");
        List<MenuItem> items = menu.getMenuList();

        for (int i = 0; i < items.size(); i++) {
            MenuItem item = items.get(i);
            System.out.println((i + 1) + ". " + item.getItemName() + " | W " + item.getItempPrice() + " | " + item.getItemInfo());
        }
        System.out.println("0. 뒤로가기");

        String selectOrder = sc.next();
        try {
            choice = Integer.parseInt(selectOrder);
        } catch (NumberFormatException e) {
            return;
        }
        if (choice == 0) {
            return; //현재 메서드 종료
        } else if (choice > 0 && choice <= items.size()) {
            MenuItem selectedItem = items.get(choice - 1);
            System.out.println("선택한 메뉴: " + selectedItem.getItemName() + " | W " + selectedItem.getItempPrice() + " | " + selectedItem.getItemInfo());

            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인        2. 취소");


            //만약 장바구니 담기에서 확인을 선택하면 장바구니 리스트에 담아지고, 2번이면 메인메뉴로 돌아가고, 나머지 번호이면 존재하지 않는 번호라고 경고하고 메인메뉴로 돌아감.
            try {
                inputCartAdd = sc.next();
                cartAdd = Integer.parseInt(inputCartAdd);
            } catch (NumberFormatException e) {
                return;
            }
            if (cartAdd == 1) {
                cart.add(selectedItem.getItemName(), 1, selectedItem.getItemPrice());
                price.totalPrice(selectedItem.getItempPrice());
            } else if (cartAdd == 2) {
                System.out.println("메인 메뉴로 돌아갑니다.");
            } else {
                System.out.println("존재하지 않는 번호입니다. 메인메뉴로 돌아갑니다.");
            }
        } else {
            System.out.println("존재하지 않는 메뉴입니다.");
        }


    }

    //메인 메뉴를 출력하는 메서드
    public void printMainMenu() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println((i + 1) + ". " + menuList.get(i).getCategoryName());

        }
        System.out.println("0. 종료");

    }


    public List<Menu> getMenuList() {
        return menuList;
    }

    public Cart getCart() {
        return cart;
    }

    public Price getPrice() {
        return price;
    }
}