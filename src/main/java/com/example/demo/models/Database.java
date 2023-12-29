package com.example.demo.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private static Database instance;
    private Map<Integer, Product> products;
    private Map<Integer, Customer> customers;
    private Map<Integer, Order> orders;
    private Map<Integer, CompoundOrder> compoundOrders;
    private Map<Integer, Category> categories;

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public Map<Integer, Customer> getCustomers() {
        return customers;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    public Map<Integer, CompoundOrder> getCompoundOrders() {
        return compoundOrders;
    }

    public Map<Integer, Category> getCategories() {
        return categories;
    }

    private Database() {
        // Initialize data structures
        products = new HashMap<>();
        customers = new HashMap<>();
        orders = new HashMap<>();
        compoundOrders = new HashMap<>();
        categories = new HashMap<>();

        // Add sample data
        initializeSampleData();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    // Methods for interacting with products
    public Product getProduct(int productId) {
        return products.get(productId);
    }

    public void addProduct(Product product) {
        products.put(products.size(), product);
    }

    // Methods for interacting with customers
    public Customer getCustomer(int customerId) {
        return customers.get(customerId);
    }

    public void addCustomer(Customer customer) {
        customers.put(customers.size(), customer);
    }

    // Methods for interacting with orders
    public Order getOrder(int orderId) {
        return orders.get(orderId);
    }

    public void addOrder(Order order) {
        orders.put(orders.size(), order);
    }

    // Methods for interacting with compound orders
    public CompoundOrder getCompoundOrder(int compoundOrderId) {
        return compoundOrders.get(compoundOrderId);
    }

    public void addCompoundOrder(CompoundOrder compoundOrder) {
        compoundOrders.put(compoundOrders.size(), compoundOrder);
    }

    // Methods for interacting with categories
    public Category getCategory(int categoryId) {
        return categories.get(categoryId);
    }

    public void addCategory(Category category) {
        categories.put(categories.size(), category);
    }

    // Initialize sample data
    public void initializeSampleData() {
        Category electronics = new Category("Electronics");
        Category clothing = new Category("Clothing");
        Category kitchen = new Category("Kitchen");

        this.addCategory(electronics);
        this.addCategory(clothing);
        this.addCategory(kitchen);

        // Add sample products
        Product laptop = new Product("Laptop", electronics, 999.99, 10);
        Product appleSmart = new Product("Apple Smart Phone", electronics, 888.99, 1);
        Product shirt = new Product("T-Shirt", clothing, 19.99, 8);
        Product jeans = new Product("Jeans", clothing, 80.99, 5);
        Product coffeeMaker = new Product("Coffee Maker", kitchen, 108.99, 5);
        Product cookWareSet = new Product("Cookware Set", kitchen, 80.99, 0);
        this.addProduct(laptop);
        this.addProduct(appleSmart);
        this.addProduct(shirt);
        this.addProduct(jeans);
        this.addProduct(coffeeMaker);
        this.addProduct(cookWareSet);

        Customer customer1 = new Customer("mostafa", 10180.0, "en");
        Customer customer2 = new Customer("alhossini", 50011.0, "en");
        Customer customer3 = new Customer("omar", 30011.0, "fr");
        Customer customer4 = new Customer("sara", 20011.0, "fr");
        this.addCustomer(customer1);
        this.addCustomer(customer2);
        this.addCustomer(customer3);
        this.addCustomer(customer4);
    }
}
