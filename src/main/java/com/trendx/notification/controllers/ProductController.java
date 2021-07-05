package com.trendx.notification.controllers;

import com.trendx.notification.entities.Product;
import com.trendx.notification.entities.ProductDTO;
import com.trendx.notification.entities.User;
import com.trendx.notification.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("type")
    public List<ProductDTO> getAllProducts(@RequestParam String type) {
        return productService.getAllProducts(type);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product p) {
        return productService.saveProduct(p);
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody Product p) {
        productService.deleteProduct(p);
    }

    @PutMapping
    public void changeProduct(@RequestBody Product p) {
        productService.changeProduct(p);
    }


}

