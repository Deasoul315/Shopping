package com.example.demo.helpers;

import java.util.Vector;

public class UserOrderUntitled {
    private Vector<Pair<String,Integer>> product;

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

    private String location;

    public UserOrderUntitled(Vector<Pair<String, Integer>> product, String location) {
        this.product = product;
        this.location = location;
    }
}
