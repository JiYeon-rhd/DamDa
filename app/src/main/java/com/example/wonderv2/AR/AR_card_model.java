package com.example.wonderv2.AR;

public class AR_card_model {
    String shop_name;
    String item_name;
    String item_gram;
    String item_price;

    public AR_card_model(){} //생성자 메서드

    public String getShop_name(){
        return shop_name;
    }
    public String getItem_name(){
        return item_name;
    }
    public String getItem_gram(){
        return item_gram;
    }
    public String getItem_price(){
        return item_price;
    }

    public void setItem_gram(String item_gram) {
        this.item_gram = item_gram;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }


    public AR_card_model(String shop_name, String item_name, String item_gram, String item_price){
        this.shop_name = shop_name;
        this.item_name = item_name;
        this.item_gram = item_gram;
        this.item_price = item_price;
    }
}
