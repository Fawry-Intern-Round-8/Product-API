package com.fawry.Product_API.service;

import com.fawry.Product_API.entity.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);

    void deleteById(int id);

    Product findById(int id);

    List<Product> findAll();
}
