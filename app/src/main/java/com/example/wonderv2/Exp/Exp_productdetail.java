package com.example.wonderv2.Exp;

public class Exp_productdetail {

    private String productName;
    private String shopName;
    private String expDay;
    private String productDetail;
    private String productIngredient;
    private String productGuide;
    private String dDay;

    public Exp_productdetail(){}

    public Exp_productdetail(String productName, String shopName, String expDay, String productDetail, String productIngredient, String productGuide, String dDay) {
        this.productName = productName;
        this.shopName = shopName;
        this.expDay = expDay;
        this.productDetail = productDetail;
        this.productIngredient = productIngredient;
        this.productGuide = productGuide;
        this.dDay = dDay;
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

    public void setProductIngredient(String productIngredient) { this.productIngredient = productIngredient;}

    public String getProductGuide() { return productGuide; }

    public void setProductGuide(String productGuide) { this.productGuide = productGuide;  }

    public String getDDay(){return dDay;}

    public void setDDay(String dDay){this.dDay=dDay;}

    @Override
    public String toString(){
        return "productdetail{" + "productName = '" + productName + '\'' +
                ", shopName = '" + shopName + '\'' +
                ", expDay = '" + expDay + '\'' +
                ", productDetail = '" + productDetail + '\'' +
                ", productIngredient = '" + productIngredient + '\'' +
                ", productGuide = '" + productGuide + '\'' +
                ", dDay = '" + dDay + '\'' +
                '}';
    }
}
