package com.example.demo.helpers;

import com.example.demo.models.Order;
import com.example.demo.services.INotifier;

public class MySchedule {
    MyDate date;
    Order order;
    INotifier notifier;

    public MySchedule(MyDate date, Order order, INotifier notifier, String msg) {
        this.date = date;
        this.order = order;
        this.notifier = notifier;
        this.msg = msg;
    }

    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public INotifier getNotifier() {
        return notifier;
    }

    public void setNotifier(INotifier notifier) {
        this.notifier = notifier;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    String msg;
}
