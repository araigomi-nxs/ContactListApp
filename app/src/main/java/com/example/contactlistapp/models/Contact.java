package com.example.contactlistapp.models;

public class Contact {
    private int id;
    private String name;
    private String phoneNumber;

    private int image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public Contact (int id, String name, String phoneNumber, int image)
    {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.image = image;

    }



}
