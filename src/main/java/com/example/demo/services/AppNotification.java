package com.example.demo.services;

import com.example.demo.models.Customer;

public class AppNotification implements INotifier{

    private Customer customer;


    public AppNotification( Customer customer) {
        this.customer=customer;
    }
    @Override
    public String send(String template) {
        return "sending to application notifications\n";
    }
}
