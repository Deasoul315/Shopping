package com.example.demo.models;

import java.util.Vector;

public class CompoundOrder {

    public Vector<Order> getOrders() {
        return orders;
    }

    public void setOrders(Vector<Order> orders) {
        this.orders = orders;
    }
    public CompoundOrder() {}
    public CompoundOrder(Vector<Order> orders, Customer customer) {
        this.orders = orders;
        this.customer = customer;
    }



    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    private Vector<Order> orders;

    private Customer customer;

    public void addOrder (Order order) {
        this.orders.add(order);
    }

    public void removeOrder (Order order) {
        this.orders.remove(order);
    }

}
