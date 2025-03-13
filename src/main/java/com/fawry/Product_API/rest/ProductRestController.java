package com.fawry.Product_API.rest;

import com.fawry.Product_API.entity.Product;
import com.fawry.Product_API.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {
    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable int productId) {
        Product product = productService.findById(productId);
        if (product == null) {
            throw new RuntimeException("Product id not found - " + productId);
        }
        return product;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        product.setId(0);
        return productService.save(product);
    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        Product product = productService.findById(productId);
        if (product == null) {
            throw new RuntimeException("Product id not found - " + productId);
        }
        productService.deleteById(productId);
        return "Deleted product id - " + productId;
    }
}
