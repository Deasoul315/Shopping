package com.example.demo.services;

import com.example.demo.helpers.Pair;
import com.example.demo.models.Customer;
import com.example.demo.models.Order;
import com.example.demo.models.Product;

import java.util.Vector;

public class CompoundOrderService implements IOrderService{
    @Override
    public boolean order (Vector<Order> orders) {
        double totalPrice = 0;

        for (int i = 0; i < orders.size(); i++) {
            Vector<Pair<Product, Integer>> receipt = orders.get(i).getReciet();
            for (int j = 0; j < receipt.size(); j++) {
                totalPrice += receipt.get(j).getFirst().getPrice() * receipt.get(j).getSecond();
            }
        }

        //calculations based on distances between countries
        double distances = 400;
        totalPrice += distances * 0.25;
        Customer customer = orders.get(0).getCustomer();
        if (totalPrice <= customer.getBalance()) {
            customer.setBalance(customer.getBalance() - totalPrice);
            return true;
        } else {
            return false;
        }
    }
}
