package com.example.kiosk.discount;

public enum UserDiscountType {
    //할인 정보를 입력해주세요.
    //사용자 유형별 할인 퍼센트
    VETERAN(10),
    MILITARY(5),
    STUDENT(3),
    DEFAULT(0);

    private final double userDiscountType;

    //생성자
    UserDiscountType(double userDiscountType){
        this.userDiscountType=userDiscountType;
    }

    //가격에서 사용자에 맞게 할인 금액 반환
    public double printDiscount(double price){
        return price*userDiscountType/100;
    }

    //가격에서 사용자에 맞는 할인을 적용한 금액 반환.
    public double printResult(double price){
        return price-printDiscount(price);
    }


    
    //할인 지정 메서드
    public static UserDiscountType discountSelect(double selectNumber){
        return switch ((int) selectNumber){
            case 1 -> VETERAN;
            case 2 -> MILITARY;
            case 3 -> STUDENT;
            default -> DEFAULT;
        };
    }
    
    public double getUserDiscountType() {
        return userDiscountType;
    }


}
