package com.ironhack.demo_lab.controller;


import com.ironhack.demo_lab.models.Product;
import com.ironhack.demo_lab.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.boot.autoconfigure.ssl.SslBundleProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static final String API_Key = "123456";

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    public void checkApiKey(String apiKey){
        if(apiKey == null){
            throw new IllegalArgumentException("Key cannot be empty");
        }
        else if(!apiKey.equals(API_Key)){
            throw new IllegalArgumentException("Wrong api key!");
        }
    }
}
