package com.example.demo.models;

import java.util.Vector;

public class Customer {
    private String username;
    private double balance;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public Customer(String username, double balance) {
        this.username = username;
        this.balance = balance;
    }
}
