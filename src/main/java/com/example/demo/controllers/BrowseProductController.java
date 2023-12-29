package com.example.demo.controllers;

import com.example.demo.models.Category;
import com.example.demo.models.Database;
import com.example.demo.models.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/product")
class BrowseProductController {



    @GetMapping("/get")
    public Map<Integer,Product> browseProduct() {

        Database db=Database.getInstance();


        return db.getProducts();
    }
}

