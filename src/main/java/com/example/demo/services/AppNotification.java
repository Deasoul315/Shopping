package com.example.demo.services;

public class AppNotification implements INotifier{

    @Override
    public String send(ITemplate template) {
        return "sending to application notifications\n";
    }
}
