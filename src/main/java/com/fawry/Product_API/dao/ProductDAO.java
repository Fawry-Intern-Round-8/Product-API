package com.fawry.Product_API.dao;

import com.fawry.Product_API.entity.Product;

import java.util.List;

public interface ProductDAO {
    Product save(Product product);

    void deleteById(int id);

    Product findById(int id);

    List<Product> findAll();

}
