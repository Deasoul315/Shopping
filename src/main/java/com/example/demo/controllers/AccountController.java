package com.example.demo.controllers;

import com.example.demo.models.Customer;
import com.example.demo.models.Database;
import com.example.demo.services.AccountManagingService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/account")
public class AccountController {

    // Validation function
    private boolean validate(Customer customer) {
        // Add your validation logic here
        // For simplicity, let's assume the validation always passes in this example
        return true;
    }
//{
//    "username" : "mostafa",
//    "balance" : "150.0",
//    "lang":"jb"
//}
    // Endpoint for browsing products
    @PostMapping("/create")
    public String create(@RequestBody Customer customer) {
        AccountManagingService accountmanaging= new AccountManagingService() ;

        if (accountmanaging.sign_up(customer.getUsername(),customer.getBalance())) {
            return "created successfully !!";
        } else {

            return "sign up failed, make sure that balance is greater than 0 and language is en or fr :)  ";
        }
    }

    @GetMapping("/get")
    public Map<Integer,Customer> get() {

//        if (validate(customer)) {
          Database db=Database.getInstance();


        return db.getCustomers();


    }
}

