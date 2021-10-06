package com.example.resturantapp.ViewHolder;

import android.net.Uri;

public class model {
    String name,purl;

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

    public Uri getPurl() {

        return Uri.parse(purl);
    }

    public void setPurl(String purl) {

        this.purl = purl;
    }
}
