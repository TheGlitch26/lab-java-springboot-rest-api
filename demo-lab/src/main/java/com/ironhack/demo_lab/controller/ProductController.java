package com.ironhack.demo_lab.controller;


import com.ironhack.demo_lab.models.Product;
import com.ironhack.demo_lab.services.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.autoconfigure.ssl.SslBundleProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static final String API_Key = "123456";

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid Product product){
        Product createdProduct = productService.create(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.findAll();
    }


    @GetMapping("/search")
    public List<Product> getProductByName(@RequestParam String name){
        return productService.getProductByName(name);
    }

    @GetMapping("/{id}")
    public Product getProductByName(@PathVariable Long id){
        return productService.findById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        productService.findById(id);
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.findById(id);
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/category/{category}")
    public List<Product> getProductByCategory(@PathVariable String category){
        return productService.getProductByCategory(category);
    }

    @GetMapping("/price")
    public List<Product> getProductsByPriceRange(@RequestParam Double min, @RequestParam Double max){
        return productService.getProductByPriceRange(min, max);
    }
}
