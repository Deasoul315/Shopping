package com.example.demo.services;

import com.example.demo.helpers.MySchedule;
import com.example.demo.models.Database;

import java.util.Queue;

public class BrowserInProccessOrder {
    public Queue<MySchedule> browse() {
        return Database.getInstance().getInProccessingOrders();
    }
}
