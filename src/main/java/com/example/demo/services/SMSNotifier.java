package com.example.demo.services;

public class SMSNotifier extends NotifierDecorator{

    public SMSNotifier(INotifier wrapped) {
        super(wrapped);
    }

    @Override
    public String send(TemplateSubstitute template) {
        super.send(template);
        return "sms sent " + "\n";
    }
}
