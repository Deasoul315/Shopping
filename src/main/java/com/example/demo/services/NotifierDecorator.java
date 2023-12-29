package com.example.demo.services;

public abstract class NotifierDecorator implements INotifier {
    private INotifier wrapped;

    public NotifierDecorator(INotifier wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public String send (ITemplate template) {
        wrapped.send(template);
        return "";
    }
}
