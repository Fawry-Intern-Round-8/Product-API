package com.fawry.product.rest;

import com.fawry.product.entity.Product;
import com.fawry.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController {
    private final ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable int productId) {
        Product product = productService.findById(productId);
        if (product == null) {
            throw new RuntimeException("Product id not found - " + productId);
        }
        return product;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        product.setId(0);
        return productService.save(product);
    }

    @PutMapping()
    public Product updateProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{productId}")
    public Product updateProductById(@PathVariable int productId, @RequestBody Product product) {
        product.setId(productId);
        return productService.save(product);
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        Product product = productService.findById(productId);
        if (product == null) {
            throw new RuntimeException("Product id not found - " + productId);
        }
        productService.deleteById(productId);
        return "Deleted product id - " + productId;
    }
}
