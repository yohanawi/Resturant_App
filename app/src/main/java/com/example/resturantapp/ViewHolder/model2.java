package com.example.resturantapp.ViewHolder;

public class model2 {
    String name, phone, id, location;
    model2()
    {

    }

    public model2(String name, String phone, String id, String location) {
        this.name = name;
        this.phone = phone;
        this.id = id;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
