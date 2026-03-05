package com.ironhack.demo_lab.services;

import com.ironhack.demo_lab.models.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ProductService {
    private Long nextId = 1L;
    Map<Long , Product> products = new HashMap<>();

    public List<Product> findAll(){
        return products.values().stream().toList();
    }

    public Product create(String name, Double price, String category, int quantity){
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);
        product.setQuantity(quantity);
        products.put(nextId++, product);
        return product;
    }

    public List<Product> getProductByName(String name){
        return products.values().stream().filter(c ->
                c.getName().toLowerCase().contains(name.toLowerCase())).toList();
    }

    public List<Product> getProductByCategory(String category){
        return products.values().stream().filter(p ->
                p.getName().toLowerCase().contains(category.toLowerCase())).toList();
    }

    public List<Product> getProductByPriceRange(Double minPrice, Double maxPrice){
        return products.values().stream().filter(p -> Double.compare(p.getPrice(), minPrice) == 1 && Double.compare(p.getPrice(), maxPrice) == -1).toList();
    }
}
