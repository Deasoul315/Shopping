package com.example.demo.models;

import com.example.demo.helpers.Pair;
import java.util.Vector;

public class Order {
    private Vector<Pair<Product, Integer>> reciet;
    private boolean status;


    public Vector<Pair<Product, Integer>> getReciet() {
        return reciet;
    }

    public void setReciet(Vector<Pair<Product, Integer>> reciet) {
        this.reciet = reciet;
    }
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Order(Vector<Pair<Product, Integer>> reciet, boolean status) {
        this.reciet = reciet;
        this.status = status;
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
