package com.example.demo.controllers;

import com.example.demo.models.Database;
import com.example.demo.models.Order;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
@RequestMapping("/order")
public class OrderView {
    private boolean validate(Order order) {
        // Add your validation logic here
        // For simplicity, let's assume the validation always passes in this example
        return true;
    }

    @PostMapping("/create")
    public String create(@RequestBody Order order) {

        if (validate(order)) {
            Database DB = Database.getInstance();
            DB.addOrder(order);

            return "SUCC";
        } else {

            return "FAILL";
        }
    }

    @GetMapping("/get")
    public Map<Integer, Order> browseProduct() {

        Database db=Database.getInstance();


        return db.getOrders();
    }
}
