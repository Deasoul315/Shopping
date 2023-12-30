package com.example.demo.helpers;

import java.util.Vector;

public class User_order {
    private Vector<Pair<String,Integer>> product;

    private String username;

    private String location;
    private String channel;

    private MyDate date;

    public Vector<Pair<String, Integer>> getProduct() {
        return product;
    }

    public void setProduct(Vector<Pair<String, Integer>> product) {
        this.product = product;
    }

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

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getLanguage() {
        return language;
    }

    public User_order(Vector<Pair<String, Integer>> product, String username, String location, String channel, MyDate date, String language) {
        this.product = product;
        this.username = username;
        this.location = location;
        this.channel = channel;
        this.date = date;
        this.language = language;
    }

    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    public void setLanguage(String language) {
        this.language = language;
    }



    private String language;


    public String toString() {
        return "UserOrder{" +
                "username='" + username + '\'' +
                ", location='" + location + '\'' +
                ", channel='" + channel + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

}
