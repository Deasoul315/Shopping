package com.example.demo.services;

import com.example.demo.models.Customer;
import com.example.demo.models.Product;

import java.util.Vector;

public interface IShippingOrderTemplate {

    String substitute(Customer customer);
}
