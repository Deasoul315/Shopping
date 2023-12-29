package com.example.demo.models;

import java.util.Vector;

public class CompoundOrder {

    private Vector<Order> orders;





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

    public CompoundOrder( Vector<Order> orders) {

        this.orders = orders;
    }

}
