package com.example.demo.controllers;

import com.example.demo.models.Category;
import com.example.demo.models.Database;
import com.example.demo.models.Product;
import com.example.demo.services.BrowseService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/category")
class CategoryController {



    @GetMapping("/get")
    public Map<String, Integer> browseCategory() {
        Database db = Database.getInstance();
        Map<String, Integer> catCount = new HashMap<>();
        Map<Integer, Category> cats = db.getCategories();
        for (Integer key : cats.keySet()) {
            catCount.put(cats.get(key).getName(), 0);
        }
        Map<Integer, Product> prods = db.getProducts();
        for (Integer key : prods.keySet()) {
            catCount.put(prods.get(key).getCat().getName(), 1 + catCount.get(prods.get(key).getCat().getName()));
        }
        
        return catCount;
    }
}

