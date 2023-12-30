package com.example.demo.helpers;


import com.example.demo.models.Order;

import java.util.Vector;

public class UserCompoundOrder {
    private String username;
    private MyDate date;
    private Vector <FriendOrderUntitled> orders;
    private String channel;
    private String location;

    public UserCompoundOrder(String username, MyDate date, Vector<FriendOrderUntitled> orders, String channel, String location, String language) {
        this.username = username;
        this.date = date;
        this.orders = orders;
        this.channel = channel;
        this.location = location;
        this.language = language;
    }

    private String language;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    public Vector<FriendOrderUntitled> getUorders() {
        return orders;
    }

    public void setUorders(Vector<FriendOrderUntitled> uorders) {
        this.orders = uorders;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}