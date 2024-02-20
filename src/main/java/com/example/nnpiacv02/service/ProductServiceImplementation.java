package com.example.nnpiacv02.service;

import com.example.nnpiacv02.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImplementation implements ProductService{
    private final Map<Integer, Product> productMap = new HashMap<>();
    public ProductServiceImplementation() {
        productMap.put(1, new Product(1, "Laptop", 1200.0));
        productMap.put(2, new Product(2, "Smartphone", 800.0));
        productMap.put(3, new Product(3, "Headphones", 200.0));
    }
    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }
    @Override
    public Product getProductById(int productId) {
        return productMap.get(productId);
    }

}
