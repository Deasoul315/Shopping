package com.example.demo.models;

public class Product {
    private String name;
    private Category cat;
    private double price;

    private int amount;
    private String vendor;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Product(String name, Category cat, double price, int amount, String vendor) {
        this.name = name;
        this.cat = cat;
        this.price = price;
        this.amount = amount;
        this.vendor = vendor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
