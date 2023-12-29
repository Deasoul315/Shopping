package com.example.demo.helpers;

import java.util.Vector;

public class User_order {
    private Vector<Pair<String,Integer>> product;
    private String username;

    private String location;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getChannal() {
        return channal;
    }

    public void setChannal(String channal) {
        this.channal = channal;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    private String channal;



    public User_order(Vector<Pair<String,Integer>> product, String username, String location, String channal, String language) {
        this.product = product;
        this.username = username;
        this.location = location;
        this.channal = channal;
        this.language = language;
    }

    public Vector<Pair<String,Integer>> getProduct() {
        return product;
    }

    public void setProduct(Vector<Pair<String,Integer>> product) {
        this.product = product;
    }

    private String language;

}
