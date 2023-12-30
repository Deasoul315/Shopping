package com.example.demo.controllers;

import com.example.demo.helpers.MySchedule;
import com.example.demo.helpers.UserCompoundOrder;
import com.example.demo.helpers.User_order;
import com.example.demo.models.*;
import com.example.demo.services.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Queue;
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
    public String createCompound(@RequestBody UserCompoundOrder uorder) {
        return "";
//        IOrderService os=new SimpleOrderService();
//        CompoundOrder corder=new CompoundOrder();
//        Database db=Database.getInstance();
//        Map<Integer, Customer> customers = db.getCustomers();
//        for (Map.Entry<Integer, Customer>  entry : customers.entrySet()) {
//
//            if(entry.getValue().getUsername().equals(uorder.getUsername())){
//                corder.setCustomer(entry.getValue());
//                break;
//            };
//        }
//        Map<Integer, Product> products = db.getProducts();
//        for (int i = 0; i < uorder.getUorders().size(); i++) {
//            Order friendOrder = new Order();
//            friendOrder.setCustomer(corder.getCustomer());
//            for (int j = 0; j < uorder.getUorders().get(i).getProduct().size() ; j++) {
//                for (Map.Entry<Integer, Product> entry : products.entrySet()) {
//                    if (entry.getValue().getName().equals(uorder.getUorders().get(i).getProduct().get(j))) {
//                        friendOrder.addReciet(entry.getValue(),uorder.getUorders().get(i).getProduct().get(j).getSecond());
//                        break;
//                    } ;
//                }
//            }
//            corder.addOrder(friendOrder);
//        }
//
//        INotifier notfierplacing,notifiershipping;
//
//        ITemplate template=null;
//
//        if(uorder.getChannal().equals("sms"))
//        {
//
//            notifiershipping=new SMSNotifier(new AppNotification(corder.getCustomer()));
//            notfierplacing=new SMSNotifier(new AppNotification(corder.getCustomer()));
//        }
//        else if (uorder.getChannal().equals("email"))
//        {
//            notifiershipping=new EmailNotifier(new AppNotification(corder.getCustomer()));
//            notfierplacing=new EmailNotifier(new AppNotification(corder.getCustomer()));
//
//        }
//        else
//        {
//            return " should send email or sms ";
//        }
//        if (uorder.getLanguage().equals("fr"))
//        {
//            template=new FrenchTemplateFactory();
//
//        }
//        else if (uorder.getLanguage().equals("en")) {
//            template=new EnglishTemplateFactory();
//        }
//        if(template==null){
//            return "language should be fr or en ";
//        }
//
//        if (os.order(corder.getOrders())) {
//            String output = "";
//            for (int i = 0; i < corder.getOrders().size(); i++) {
//                Vector<Product> prods = new Vector<Product>();
//                for (int j = 0; j < corder.getOrders().get(i).getReciet().size(); j++) {
//                    prods.add(corder.getOrders().get(i).getReciet().get(j).getFirst());
//                }
//                output += notifiershipping.send(template.createPlaceingOrderTemplate().substitute(corder.getOrders().get(i).getCustomer(), prods));
//                output += "\n";
//                output += notfierplacing.send((template.createShippingOrderTemplate().substitute(corder.getOrders().get(i).getCustomer())));
//                output += "\n\n";
//            }
//
//            return  output;
//        } else {
//            return "invalid order the order should have valid products, user and sufficient balance";
//        }
    }
    @PostMapping("/create/simple")
    public String createSimple(@RequestBody User_order uorder) {
        if (uorder.getChannel() == null) {
            return "channel must be selected";
        }
        if (uorder.getProduct() == null) {
            return "products must be set";
        }
        if (uorder.getLanguage() == null) {
            return "language must not be empty";
        }
        if(uorder.getLocation() == null) {
            return "location must not be empty";
        }
        if(uorder.getDate() == null) {
            return "date of shipment must not be null";
        }
        if(uorder.getDate().getDay() == null) {
            return "the day must not be null";
        }
        if(uorder.getDate().getMonth() == null) {
            return "the month must not be null";
        }
        if(uorder.getDate().getYear() == null) {
            return "the year must not be null";
        }
        for (int i = 0; i < uorder.getProduct().size(); i++) {
            if (uorder.getProduct().get(i).getFirst() == null) {
                return "product name not be null";
            }
            if (uorder.getProduct().get(i).getSecond() == null) {
                return "quantity must not be null";
            }
        }
        System.out.println(uorder.toString());
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
        if (order.getCustomer() == null) {
            return "no username matches the username sent";
        }
        Map<Integer, Product> products = db.getProducts();
        for (int i = 0; i < uorder.getProduct().size() ; i++) {


            for (Map.Entry<Integer, Product> entry : products.entrySet()) {

                if (entry.getValue().getName().equals(uorder.getProduct().get(i).getFirst())) {
                    order.addReciet (entry.getValue(),uorder.getProduct().get(i).getSecond());
                    break;
                }
            }
            if (i + 1 != order.getReciet().size()) {
                return uorder.getProduct().get(i).getFirst() + " not found";
            }
            if (uorder.getProduct().get(i).getSecond() < 0) {
                return uorder.getProduct().get(i).getSecond().toString() + " negative value not allowed";
            }
        }
        order.setLocation(uorder.getLocation());

        Vector<Order> orderVector = new Vector<>();
        orderVector.add(order);
        INotifier notfierplacing, notifiershipping;

        ITemplate template=null;

        if(uorder.getChannel().equals("sms"))
        {

            notifiershipping=new SMSNotifier(new AppNotification(order.getCustomer()));
            notfierplacing=new SMSNotifier(new AppNotification(order.getCustomer()));
        }
        else if (uorder.getChannel().equals("email"))
        {
            notifiershipping=new EmailNotifier(new AppNotification(order.getCustomer()));
            notfierplacing=new EmailNotifier(new AppNotification(order.getCustomer()));

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

        Vector<Product> prods = new Vector<Product>();
        for (int i = 0; i < order.getReciet().size(); i++) {
            prods.add(order.getReciet().get(i).getFirst());
        }

        if (os.order(orderVector, uorder.getDate(), notifiershipping, template.createShippingOrderTemplate().substitute(order.getCustomer()))) {
            return notfierplacing.send(template.createPlaceingOrderTemplate().substitute(order.getCustomer(), prods));
        } else {
            return "invalid order the order should have valid products, user and sufficient balance";
        }
    }

    @GetMapping("/get")
    public Map<Integer, Order> browseOrder() {

        BrowseOrderService bos = new BrowseOrderService();

        return bos.browse();
    }
    @GetMapping("/get/ship/get")
    public Vector<Order> browseShip() {
        BrowserInProccessOrder bipo = new BrowserInProccessOrder();
        Queue<MySchedule> mySchedules = bipo.browse();
        Vector<Order> orders = new Vector<>();
        for (MySchedule mySchedule : mySchedules) {
            Order order = mySchedule.getOrder();
            orders.add(order);
        }
        return orders;
    }
    @PostMapping("/get/ship/create")
    public String ship(@RequestParam(name = "id") Integer id) {
        if (id == null) {
            return "id must be provided";
        }
        OrderQueuingService oqs = new OrderQueuingService();
        return oqs.ship(id);
    }
}
