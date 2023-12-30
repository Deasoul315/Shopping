package com.example.demo.services;

import com.example.demo.helpers.MyDate;
import com.example.demo.helpers.Pair;
import com.example.demo.models.Customer;
import com.example.demo.models.Database;
import com.example.demo.models.Order;
import com.example.demo.models.Product;

import java.util.Vector;

public class SimpleOrderService implements IOrderService{
    @Override
    public boolean order (Vector<Order> orders, MyDate date, INotifier notifier, String template) {
        double totalPrice = 0;

        Vector<Pair<Product, Integer>> receipt = orders.get(0).getReciet();
        for (int j = 0; j < receipt.size(); j++) {
            totalPrice += receipt.get(j).getFirst().getPrice() * receipt.get(j).getSecond();
        }

        //calculations based on distances between countries
        double distances = 200;
        totalPrice += distances * 0.25;
        Customer customer = orders.get(0).getCustomer();
        if (totalPrice <= customer.getBalance()) {
            OrderQueuingService oqs = new OrderQueuingService();
            oqs.schedule(orders.get(0), date, notifier, template);
            return true;
        } else {
            return false;
        }
    }
}
