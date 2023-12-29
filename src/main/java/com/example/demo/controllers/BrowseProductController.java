package com.example.demo.controllers;

import com.example.demo.models.Category;
import com.example.demo.models.Database;
import com.example.demo.models.Product;
import com.example.demo.services.BrowseService;
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

        BrowseService bs= new BrowseService();



        return bs.browse();
    }
}

