package com.trendx.notification.controllers;

import com.trendx.notification.entities.Product;
import com.trendx.notification.repositories.ProductRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final KafkaTemplate<String, Product> kafkaTemplate;
    private final String topic = "topic";

    public ProductController(ProductRepository productRepository, KafkaTemplate<String, Product> kafkaTemplate) {
        this.productRepository = productRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public void saveProduct(@RequestBody Product p) {
        productRepository.save(p);
    }

    @PutMapping
    public void changeProduct(@RequestBody Product p) {
        double currentMobilePrice = 0, currentPrice = 0;
        List<Product> productList = productRepository.findAll();

        for (Product pro : productList) {
            if (pro.getBarcode().equals(p.getBarcode())) {
                currentMobilePrice = pro.getMobileSalesPrice();
                currentPrice = pro.getSalesPrice();
                break;
            }
        }

        Product product = new Product(p.getBarcode(), p.getDescription(), p.getSalesPrice(), p.getMobileSalesPrice());

        if (currentPrice != product.getSalesPrice() || currentMobilePrice != product.getMobileSalesPrice()) {
            kafkaTemplate.send(topic, UUID.randomUUID().toString(), product);
        }

        productRepository.save(product);
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody Product p) {
        productRepository.delete(p);
    }

    // ----------------- Silinecek--------------
    /*@GetMapping("/deneme")
    public void getAllUsers (){
        WebClient client = WebClient.create();
        String uri = "localhost:8080/users";
        WebClient.ResponseSpec responseSpec = client.get().uri(uri).retrieve();
        String responseBody = responseSpec.bodyToMono(String.class).block();
        System.out.println(responseBody);
    }*/
    // ----------------- Silinecek-------------------


}

