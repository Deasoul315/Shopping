package com.example.demo.controllers;

import com.example.demo.helpers.Pair;
import com.example.demo.models.Customer;
import com.example.demo.models.Database;
import com.example.demo.models.Order;
import com.example.demo.models.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Vector;
@RestController
@RequestMapping("/account")
public class AccountCreateView {

    // Validation function
    private boolean validate(Customer customer) {
        // Add your validation logic here
        // For simplicity, let's assume the validation always passes in this example
        return true;
    }

    // Endpoint for browsing products
    @PostMapping("/create")
    public String create(@RequestBody Customer customer) {

        if (validate(customer)) {
            Database DB = Database.getInstance();
            DB.addCustomer(customer);

            return "SUCC";
        } else {

            return "FAILL";
        }
    }

    @GetMapping("/get")
    public Map<Integer,Customer> get() {

//        if (validate(customer)) {
          Database db=Database.getInstance();


        return db.getCustomers();


    }
}

