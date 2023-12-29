package com.example.demo.services;

import com.example.demo.models.Customer;
import com.example.demo.models.Database;

import javax.xml.crypto.Data;

public class AccountManagingService {
   public boolean sign_up (String username, double balance, String lang) {
        if (balance < 0 || (!lang.equals("en")  && ! lang.equals("fr") )) {

            return false;
        }
//       System.out.println("7omaaar");
        Customer customer = new Customer(username, balance, lang);
        Database db = Database.getInstance();
        db.addCustomer(customer);
        return true;
    }
}
