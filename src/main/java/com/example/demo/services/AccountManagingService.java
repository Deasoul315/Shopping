package com.example.demo.services;

import com.example.demo.models.Customer;
import com.example.demo.models.Database;

import javax.xml.crypto.Data;

public class AccountManagingService {
   public boolean sign_up (String username, double balance) {
        if (balance < 0) {

            return false;
        }

        Customer customer = new Customer(username, balance);
        Database db = Database.getInstance();
        db.addCustomer(customer);
        return true;
    }
}
