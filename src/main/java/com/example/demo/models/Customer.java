package com.example.demo.models;

import java.util.Vector;

public class Customer {
    private String username;
    private double balance;
    private String lang;

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

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Customer(String username, double balance, String lang) {
        this.username = username;
        this.balance = balance;
        this.lang = lang;
    }
}
