package com.example.demo.helpers;

import java.util.Vector;

public class User_order {
    private Vector<Pair<String,Integer>> product;
    private String username;

    private String location;
    private String channel;

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

    public void setLanguage(String language) {
        this.language = language;
    }

    public User_order(Vector<Pair<String, Integer>> product, String username, String location, String channel, String language) {
        this.product = product;
        this.username = username;
        this.location = location;
        this.channel = channel;
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
