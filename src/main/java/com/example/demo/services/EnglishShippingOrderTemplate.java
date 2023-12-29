package com.example.demo.services;

import com.example.demo.models.Customer;
import com.example.demo.models.Product;

import java.util.Vector;

public class EnglishShippingOrderTemplate implements IShippingOrderTemplate{
    @Override
    public String substitute(Customer customer) {
        return "Dear " + customer.getUsername() + " your shipment is completed";
    }
}
