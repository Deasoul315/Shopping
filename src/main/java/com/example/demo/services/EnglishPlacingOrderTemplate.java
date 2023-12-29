package com.example.demo.services;

import com.example.demo.models.Customer;
import com.example.demo.models.Product;

import java.util.Vector;

public class EnglishPlacingOrderTemplate implements IPlacingOrderTemplate{

    @Override
    public String substitute(Customer customer, Vector<Product> products) {
        String productsNames = "";
        for (int i = 0; i < products.size(); i++) {
            productsNames += products.get(i).getName();
            if (i != products.size() - 1) {
                productsNames += ", ";
            }
        }
        return "Dear " + customer.getUsername() + " , your booking of the " + productsNames + " is confirmed. thanks for using our store :)";
    }
}
