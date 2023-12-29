package com.example.demo.services;

import com.example.demo.models.Customer;

public abstract class NotifierDecorator implements INotifier {
    private INotifier wrapped;

    public NotifierDecorator(INotifier wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public String send (TemplateSubstitute template) {
        wrapped.send(template);
        return "";
    }
}
