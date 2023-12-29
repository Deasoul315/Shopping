package com.example.demo.helpers;


import com.example.demo.models.Order;

import java.util.Vector;

public class UserCompoundOrder {
    private String username;
    private Vector <UserOrderUntitled> uorders;
    private String channal;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    private String location;
    private String language;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Vector<UserOrderUntitled> getUorders() {
        return uorders;
    }

    public void setUorders(Vector<UserOrderUntitled> uorders) {
        this.uorders = uorders;
    }

    public String getChannal() {
        return channal;
    }

    public void setChannal(String channal) {
        this.channal = channal;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserCompoundOrder(String username, Vector<UserOrderUntitled> uorders, String channal, String location, String language) {
        this.username = username;
        this.uorders = uorders;
        this.channal = channal;
        this.location = location;
        this.language = language;
    }

}