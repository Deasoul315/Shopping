package com.example.demo.helpers;

import com.example.demo.models.CompoundOrder;
import com.example.demo.models.Order;
import com.example.demo.services.INotifier;

import java.util.Vector;

public class MyCompoundSchedule {
    MyDate date;
    CompoundOrder orders;
    INotifier notifier;


    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }


    public CompoundOrder getOrder() {
        return orders;
    }

    public void setOrder(CompoundOrder order) {
        this.orders = order;
    }

    public MyCompoundSchedule(MyDate date, CompoundOrder order, INotifier notifier, String msg) {
        this.date = date;
        this.orders = order;
        this.notifier = notifier;
        this.msg = msg;
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
