package com.example.demo.services;

import com.example.demo.helpers.MyDate;
import com.example.demo.models.Order;

import java.util.Vector;

public interface IOrderService {
    boolean order(Vector<Order> orders, MyDate date, INotifier notifier, String template);
}
