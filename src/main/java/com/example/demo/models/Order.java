package com.example.demo.models;

import com.example.demo.helpers.Pair;
import java.util.Vector;

public class Order {
    private Vector<Pair<Product, Integer>> reciet;


    private String location;

    private Customer customer;
    public String getLocation() {
        return location;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Vector<Pair<Product, Integer>> getReciet() {
        return reciet;
    }

    public void setReciet(Vector<Pair<Product, Integer>> reciet) {
        this.reciet = reciet;
    }

    public Order(){}


    public Order(Vector<Pair<Product, Integer>> reciet, String location, Customer customer) {
        this.reciet = reciet;
        this.location = location;
        this.customer = customer;
    }

    public void addReciet(Product prod, Integer amount) {
        this.reciet.add(new Pair<Product, Integer>(prod, amount));
    }
    public void removeReciet(Product prod) {
        for (int i = 0; i < this.reciet.size(); i++) {
            if (this.reciet.get(i).getFirst().equals(prod)) {
                this.reciet.remove(i);
                break;
            }
        }
    }
}
