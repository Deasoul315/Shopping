package com.example.demo.controllers;

import com.example.demo.helpers.Pair;
//import com.example.demo.models.Category;
import com.example.demo.models.Order;
import com.example.demo.models.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Vector;

    class Orderview {

    private Vector<Pair<Product, Integer>> reciet;
    private boolean status;


    // Constructor

    public Orderview() {
    }


    @Value("${street}")
    public void setStreet( Vector<Pair<Product, Integer>> reciet) {
        this.reciet = reciet;
    }

    @Value("${city}")
    public void setCity( boolean status) {
        this.status = status;
    }



    // Validation function
    private boolean validate() {
        // Add your validation logic here
        // For simplicity, let's assume the validation always passes in this example
        return true;
    }

    // Endpoint for browsing products
    @GetMapping("/orderview")
    public Order orderview() {
        if (validate()) {

            return new Order(reciet, status );
        } else {

            return null;
        }
    }
}




