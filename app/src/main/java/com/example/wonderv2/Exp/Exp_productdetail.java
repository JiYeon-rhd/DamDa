package com.example.wonderv2.Exp;

public class Exp_productdetail {

    public String productName;
    public String shopName;
    public String expDay;
    public String productDetail;
    public String productIngredient;
    public String productGuide;

    public Exp_productdetail(){}

    public Exp_productdetail(String productName, String shopName, String expDay, String productDetail, String productIngredient, String productGuide) {
        this.productName = productName;
        this.shopName = shopName;
        this.expDay = expDay;
        this.productDetail = productDetail;
        this.productIngredient = productIngredient;
        this.productGuide = productGuide;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getExpDay(){
        return expDay;
    }

    public void setExpDay(String expDay){
        this.expDay = expDay;
    }

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

    @Override
    public String toString(){
        return "productdetail{" + "productName = '" + productName + '\'' +
                ", shopName = '" + shopName + '\'' +
                ", expDay = '" + expDay + '\'' +
                ", productDetail = '" + productDetail + '\'' +
                ", productIngredient = '" + productIngredient + '\'' +
                ", productGuide = '" + productGuide + '\'' +
                '}';
    }
}
