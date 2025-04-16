package com.fawry.product.service;

import com.fawry.product.entity.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);

    void deleteById(int id);

    Product findById(int id);

    List<Product> findAll();
}
