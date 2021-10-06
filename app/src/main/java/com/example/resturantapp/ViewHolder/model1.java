package com.example.resturantapp.ViewHolder;

import android.net.Uri;

public class model1 {
    String name, price, description, purl;


    public model1(String name, String price, String description, String purl) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.purl = purl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Uri getPurl() {
        return Uri.parse(purl);
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}
