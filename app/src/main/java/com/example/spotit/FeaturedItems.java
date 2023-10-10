package com.example.spotit;

public class FeaturedItems {

    String item_name, price, city, date;

    public FeaturedItems(String item_name, String price, String city, String date) {
        this.item_name = item_name;
        this.price = price;
        this.city = city;
        this.date = date;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
