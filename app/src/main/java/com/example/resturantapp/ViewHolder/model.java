package com.example.resturantapp.ViewHolder;

public class model {
    String name,purl;
    model()
    {

    }

    public model(String name, String purl) {
        this.name = name;
        this.purl = purl;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getPurl() {

        return purl;
    }

    public void setPurl(String purl) {

        this.purl = purl;
    }
}
