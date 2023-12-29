package com.example.demo.controllers;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class BrowseProductController {

    private String name;
    private Category cat;
    private double price;
    private int amount;

    // Constructor

    public BrowseProductController() {
    }


    @Value("${street}")
    public void setStreet(String name) {
        this.name = name;
    }

    @Value("${city}")
    public void setCity(Category cat) {
        this.cat = cat;
    }

    @Value("${postalCode}")
    public void setPostalCode(double price) {
        this.price = price;
    }

    @Value("${country}")
    public void setCountry(int amount) {
        this.amount = amount;
    }

    // Validation function
    private boolean validate() {
        // Add your validation logic here
        // For simplicity, let's assume the validation always passes in this example
        return true;
    }

    // Endpoint for browsing products
    @GetMapping("/browseProduct")
    public Product browseProduct() {
        if (validate()) {

            return new Product(name, cat ,price ,amount );
        } else {

            return null;
        }
    }
}

