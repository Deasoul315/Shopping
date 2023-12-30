package com.example.demo.helpers;

import java.util.Vector;

public class FriendOrderUntitled {
    public FriendOrderUntitled(Vector<Pair<String, Integer>> product, String location) {
        this.product = product;
        this.location = location;
    }

    private Vector<Pair<String,Integer>> product;
    private String location;

    public Vector<Pair<String, Integer>> getProduct() {
        return product;
    }

    public void setProduct(Vector<Pair<String, Integer>> product) {
        this.product = product;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
