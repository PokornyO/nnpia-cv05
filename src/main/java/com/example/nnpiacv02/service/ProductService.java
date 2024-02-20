package com.example.nnpiacv02.service;

import com.example.nnpiacv02.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(int productId);
}
