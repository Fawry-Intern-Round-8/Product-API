package com.fawry.product.dao;

import com.fawry.product.entity.Product;

import java.util.List;

public interface ProductDAO {
    Product save(Product product);

    void deleteById(int id);

    Product findById(int id);

    List<Product> findAll();

}
