package com.example.retrofitexample.model;

import java.util.ArrayList;

public class UsersData {
    private ArrayList<String> name;
    private ArrayList<String> email;
    private ArrayList<String> imageUrl;

    public ArrayList<String> getAllName() {
        return name;
    }

    public void setAllName(ArrayList<String> name) {
        this.name = name;
    }

    public ArrayList<String> getAllEmail() {
        return email;
    }

    public void setAllEmail(ArrayList<String> email) {
        this.email = email;
    }

    public ArrayList<String> getAllImageUrl() {
        return imageUrl;
    }

    public void setAllImageUrl(ArrayList<String> imageUrl) {
        this.imageUrl = imageUrl;
    }


    public String getName(int index) {
        return this.name.get(index);
    }
    public String getEmail(int index) {
        return this.email.get(index);
    }
    public String getImageUrl(int index) {
        return this.imageUrl.get(index);
    }


    public void setName(String name) {
        this.name.add(name);
    }
    public void setEmail(String email) {
        this.email.add(email);
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl.add(imageUrl);
    }




}
