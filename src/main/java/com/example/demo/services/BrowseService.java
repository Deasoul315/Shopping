package com.example.demo.services;

import com.example.demo.models.Database;
import com.example.demo.models.Product;

import javax.xml.crypto.Data;
import java.util.Map;

public class BrowseService {
    public Map<Integer, Product> browse () {
        Database db = Database.getInstance();
        return db.getProducts();
    }
}
