package com.example.demo.services;

public class EmailNotifier extends NotifierDecorator{
    public EmailNotifier(INotifier wrapped) {
        super(wrapped);
    }

    @Override
    public String send(String template) {
        super.send(template);
        return "email sent " + "\n";
    }
}
