package com.example.kiosk.discount;

public enum UesrDiscountType {
    //할인 정보를 입력해주세요.
    //사용자 유형별 할인 퍼센트
    VETERAN(10), MILITARY(5),STUDENT(3), DEFAULT(0);

    private final int userDiscountType;

    //생성자
    UesrDiscountType(int userDiscountType){
        this.userDiscountType=userDiscountType;
    }

    //가격에서 사용자에 맞게 할인 금액 반환
    public int printDiscount(int price){
        return price*userDiscountType/100;
    }

    //가격에서 사용자에 맞는 할인을 적용한 금액 반환.
    public int printResult(int price){
        return price-printDiscount(price);
    }

    public int getUserDiscountType() {
        return userDiscountType;
    }
}
