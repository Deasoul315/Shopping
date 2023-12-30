package com.example.demo.services;

import com.example.demo.helpers.MyDate;
import com.example.demo.helpers.MySchedule;
import com.example.demo.helpers.Pair;
import com.example.demo.models.Customer;
import com.example.demo.models.Database;
import com.example.demo.models.Order;
import com.example.demo.models.Product;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.Queue;
import java.util.Vector;

public class OrderQueuingService {

    public void schedule(Order order, MyDate date, INotifier notifier, String msg) {
        Database db = Database.getInstance();
        db.addProccessOrder(order, date, notifier, msg);
    }
    public boolean cancel(Integer id) {
        Database db = Database.getInstance();

        if (db.removeProccessOrder(id)) {
            return true;
//            return "order not found!";
        }
        return false;
//        return "order has been removed successfully!";
    }
    public String ship(Integer id) {
        Database db = Database.getInstance();
        MySchedule schedule = db.getInProccessingOrders().stream().filter(obj -> db.getOrder(id) == obj.getOrder()).findFirst().orElse(null);
        if (schedule == null) {
            return "order id not found";
        }
        double totalPrice = 0;

        Vector<Pair<Product, Integer>> receipt = schedule.getOrder().getReciet();
        for (int j = 0; j < receipt.size(); j++) {
            totalPrice += receipt.get(j).getFirst().getPrice() * receipt.get(j).getSecond();
        }

        //calculations based on distances between countries
        double distances = 200;
        totalPrice += distances * 0.25;

        Customer customer = schedule.getOrder().getCustomer();
        customer.setBalance(customer.getBalance() - totalPrice);
        db.removeProccessOrder(id);
        return schedule.getNotifier().send(schedule.getMsg());
//            return "order not found!";
//        return "order has been removed successfully!";
    }
}
