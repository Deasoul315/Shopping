package com.example.demo.controllers;

import com.example.demo.helpers.Pair;
import com.example.demo.models.Customer;
import com.example.demo.models.Database;
import com.example.demo.models.Order;
import com.example.demo.models.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Vector;

public class AccountCreateView {
    private String username;
    private double balance;
    private String lang;

    // Constructor

    public AccountCreateView() {
    }


    @Value("${street}")
    public void setStreet(String username ) {
        this.username = username;
    }

    @Value("${city}")
    public void setCity( String lang) {
        this.lang= lang;
    }
    public void setBalance( double balance) {
        this.balance = balance;
    }



    // Validation function
    private boolean validate(Customer customer) {
        // Add your validation logic here
        // For simplicity, let's assume the validation always passes in this example
        return true;
    }

    // Endpoint for browsing products
    @PostMapping("/account")
    public String account(@RequestBody Customer customer) {

        if (validate(customer)) {
            Database DB=Database.getInstance();
            DB.addCustomer(customer);

            return "SUCC" ;
        } else {

            return "FAILL";
        }
    }
}


