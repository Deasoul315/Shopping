package com.example.demo.services;

import com.example.demo.helpers.MyCompoundSchedule;
import com.example.demo.helpers.MyDate;
import com.example.demo.helpers.MySchedule;
import com.example.demo.helpers.Pair;
import com.example.demo.models.*;

import java.util.Vector;

public class CompoundOrderQueueingService implements IOrderQueuingService{
    @Override
    public void schedule(Vector<Order> orders, MyDate date, INotifier notifier, String msg) {
        Database db = Database.getInstance();
        CompoundOrder corder = new CompoundOrder();
        corder.setCustomer(orders.get(0).getCustomer());
        for (int i = 0; i < orders.size(); i++) {
            corder.addOrder(orders.get(i));
        }
        db.addProccessCompoundOrder(corder, date, notifier, msg);
    }
    @Override
    public boolean cancel(Integer id) {
        Database db = Database.getInstance();
        if (db.removeProccessCompoundOrder(id)) {
            db.getCompoundOrders().remove(id);
            return true;
        }
        return false;

    }
    @Override
    public String ship(Integer id) {
        Database db = Database.getInstance();
        MyCompoundSchedule schedule = db.getInProccessingCompoundOrders().stream().filter(obj -> db.getCompoundOrder(id) == obj.getOrder()).findFirst().orElse(null);
        if (schedule == null) {
            return "order id not found";
        }
        double totalPrice = 0;
        for (int i = 0; i < schedule.getOrder().getOrders().size(); i++) {
            Vector<Pair<Product, Integer>> receipt = schedule.getOrder().getOrders().get(i).getReciet();
            for (int j = 0; j < receipt.size(); j++) {
                totalPrice += receipt.get(j).getFirst().getPrice() * receipt.get(j).getSecond();
            }
        }

        //calculations based on distances between countries
        double distances = 200;
        totalPrice += distances * 0.25;

        Customer customer = schedule.getOrder().getCustomer();
        customer.setBalance(customer.getBalance() - totalPrice);
        db.removeProccessCompoundOrder(id);
        return schedule.getNotifier().send(schedule.getMsg());
//            return "order not found!";
//        return "order has been removed successfully!";
    }
}
