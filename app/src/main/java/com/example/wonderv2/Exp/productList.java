package com.example.wonderv2.Exp;

public class productList {
    private String shopName;
    private String productName;
    private String expDay;
    private String dDay;

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public String getProductIngredient() {
        return productIngredient;
    }

    public void setProductIngredient(String productIngredient) {
        this.productIngredient = productIngredient;
    }

    public String getProductGuide() {
        return productGuide;
    }

    public void setProductGuide(String productGuide) {
        this.productGuide = productGuide;
    }

    private String productDetail;
    private String productIngredient;
    private String productGuide;

    public productList(){}

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getExpDay() {
        return expDay;
    }

    public void setExpDay(String expDay) {
        this.expDay = expDay;
    }

    public String getDDay() {return dDay;}

    public void setDDay(String dDay) { this.dDay = dDay; }


    public productList(String shopName, String productName, String expDay, String dDay){
        this.shopName = shopName;
        this.productName = productName;
        this.expDay = expDay;
        this.dDay = dDay;
    }

}
