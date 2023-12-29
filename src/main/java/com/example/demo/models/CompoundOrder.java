package com.example.demo.models;

import java.util.Vector;

public class CompoundOrder {
    private boolean status;
    private Vector<Order> orders;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Vector<Order> getOrders() {
        return orders;
    }

    public void setOrders(Vector<Order> orders) {
        this.orders = orders;
    }
    public void addOrder(Order order) {
        this.orders.add(order);
    }
    public void remooooOrder(Order order) {
        this.orders.remove(order);
    }

    public CompoundOrder(boolean status, Vector<Order> orders) {
        this.status = status;
        this.orders = orders;
    }

}
