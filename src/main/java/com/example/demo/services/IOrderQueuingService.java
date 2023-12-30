package com.example.demo.services;

import com.example.demo.helpers.MyDate;
import com.example.demo.helpers.MySchedule;
import com.example.demo.helpers.Pair;
import com.example.demo.models.Customer;
import com.example.demo.models.Database;
import com.example.demo.models.Order;
import com.example.demo.models.Product;

import java.util.Vector;

public interface IOrderQueuingService {
    public void schedule(Vector<Order> order, MyDate date, INotifier notifier, String msg);
    public boolean cancel(Integer id);
    public String ship(Integer id);
}
