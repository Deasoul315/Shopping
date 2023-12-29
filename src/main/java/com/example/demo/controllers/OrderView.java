package com.example.demo.controllers;

import com.example.demo.helpers.User_order;
import com.example.demo.models.Customer;
import com.example.demo.models.Database;
import com.example.demo.models.Order;
import com.example.demo.models.Product;
import com.example.demo.services.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Vector;

@RestController
@RequestMapping("/order")
public class OrderView {
    private boolean validate(Order order) {
        // Add your validation logic here
        // For simplicity, let's assume the validation always passes in this example
        return true;
    }

    @PostMapping("/create/compound")
    public String createCompound(@RequestBody Order order) {

        if (validate(order)) {
            Database DB = Database.getInstance();
            DB.addOrder(order);

            return "SUCC";
        } else {

            return "FAILL";
        }
    }
    @PostMapping("/create/simple")
    public String createSimple(@RequestBody User_order uorder) {
        IOrderService os=new SimpleOrderService();
        Order order=new Order();
        Database db=Database.getInstance();
        Map<Integer, Customer> customers = db.getCustomers();
        for (Map.Entry<Integer, Customer>  entry : customers.entrySet()) {

            if(entry.getValue().getUsername().equals(uorder.getUsername())){
                order.setCustomer(entry.getValue());
                break;
            };
        }
        Map<Integer, Product> products = db.getProducts();
        for (int i = 0; i < uorder.getProduct().size() ; i++) {


            for (Map.Entry<Integer, Product> entry : products.entrySet()) {

                if (entry.getValue().getName().equals(uorder.getProduct().get(i))) {
                    order.addReciet (entry.getValue(),uorder.getProduct().get(i).getSecond());
                    break;
                } ;
            }
        }
        order.setLocation(uorder.getLocation());

        Vector<Order> orderVector = new Vector<>();
        orderVector.add(order);
        INotifier notfierplacing,notifiershipping;

        ITemplate template=null;

        if(uorder.getChannal().equals("sms"))
        {

            notifiershipping=new SMSNotifier(new AppNotification());
            notfierplacing=new SMSNotifier(new AppNotification());
        }
        else if (uorder.getChannal().equals("email"))
        {
            notifiershipping=new EmailNotifier(new AppNotification());
            notfierplacing=new EmailNotifier(new AppNotification());

        }
        else
        {
         return " should send email or sms ";
        }
        if (uorder.getLanguage().equals("fr"))
        {
            template=new FrenchTemplateFactory();

        }
        else if (uorder.getLanguage().equals("en")) {
            template=new EnglishTemplateFactory();
        }
        if(template==null){
            return "language should be fr or en ";
        }
        if (os.order(orderVector)) {
            notifiershipping.send(template);
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
