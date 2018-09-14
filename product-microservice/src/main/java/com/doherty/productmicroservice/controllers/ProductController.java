package com.doherty.productmicroservice.controllers;

import com.doherty.productmicroservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String getProductNameFromId(@PathVariable Long id) {
        System.out.println("HIT THE PRODUCT CONTROLLER");
        System.out.println(id);
        String name = productService.getNameFromId(id);
        System.out.println("NAME:");
        System.out.println(name);
        return name;
    }

}
