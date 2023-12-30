package com.example.demo.services;

import com.example.demo.models.Database;
import com.example.demo.models.Order;

import java.util.Map;

public class BrowseOrderService {
    public Map<Integer, Order> browse() {
        return Database.getInstance().getOrders();
    }
}
