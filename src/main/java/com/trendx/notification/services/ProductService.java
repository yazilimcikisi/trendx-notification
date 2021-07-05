package com.trendx.notification.services;

import com.trendx.notification.entities.Product;
import com.trendx.notification.entities.ProductDTO;
import com.trendx.notification.repositories.ProductRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final KafkaTemplate kafkaTemplate;
    private final String topic = "topic";


    public ProductService(ProductRepository productRepository, KafkaTemplate kafkaTemplate) {
        this.productRepository = productRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<ProductDTO> getAllProducts(String type) {
        List<Product> productList = getAllProducts();
        List<ProductDTO> productDTOList = new ArrayList<>();
        productList.stream().forEach(product -> {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setBarcode(product.getBarcode());
            productDTO.setDescription(product.getDescription());
            if (type.equals("mobile")) {
                productDTO.setSalesPrice(product.getMobileSalesPrice());
            } else if (type.equals("web")) {
                productDTO.setSalesPrice(product.getSalesPrice());
            }
            productDTOList.add(productDTO);
        });

        return productDTOList;
    }

    public Product saveProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    public Product findProductById(String barcode) {
        return productRepository.findById(barcode).get();
    }

    public void changeProduct(Product product) {
        double currentMobilePrice = 0, currentPrice = 0;
        Product currentProduct = findProductById(product.getBarcode());
        currentPrice = currentProduct.getSalesPrice();
        currentMobilePrice = currentProduct.getMobileSalesPrice();

        if (currentPrice != product.getSalesPrice() || currentMobilePrice != product.getMobileSalesPrice()) {
            kafkaTemplate.send(topic, UUID.randomUUID().toString(), product);
        }
        productRepository.save(product);

    }

}
