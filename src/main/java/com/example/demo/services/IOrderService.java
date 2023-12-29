package com.example.demo.services;

import com.example.demo.models.Order;

import java.util.Vector;

public interface IOrderService {
    boolean order(Vector<Order> orders);
}
