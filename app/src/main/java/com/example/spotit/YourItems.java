package com.example.spotit;

public class YourItems

{
    String item_name, price, view_count, date;

    public YourItems(String item_name, String price, String view_count, String date) {
        this.item_name = item_name;
        this.price = price;
        this.view_count = view_count;
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

    public String getView_count() {
        return view_count;
    }

    public void setView_count(String view_count) {
        this.view_count = view_count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
