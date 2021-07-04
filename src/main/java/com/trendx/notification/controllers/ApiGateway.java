package com.trendx.notification.controllers;

import com.trendx.notification.client.Client;
import com.trendx.notification.entities.Product;
import com.trendx.notification.entities.ProductDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/resources")
public class ApiGateway {

    // mobile web ayrımı product controller'da yapılabilir !!

    @GetMapping("/mobileClient")
    public List<ProductDTO> getAllProductsForMobileClient() {
        WebClient webClient = WebClient.create();
        String uri = "localhost:8080/products";
        Flux<Product> productFlux = webClient.get().uri(uri).retrieve().bodyToFlux(Product.class);
        productFlux.toStream().forEach(p -> System.out.println(p.toString()));
        List<ProductDTO> productDTOList = new ArrayList<>();
        productFlux.toStream().forEach(p -> productDTOList.add(Client.convertProductToProductDTOForMobileClients(p)));
        return productDTOList;
    }

    @GetMapping("/webClient")
    public List<ProductDTO> getAllProductsForWebClient() {
        WebClient webClient = WebClient.create();
        String uri = "localhost:8080/products";
        Flux<Product> productFlux = webClient.get().uri(uri).retrieve().bodyToFlux(Product.class);
        productFlux.toStream().forEach(p -> System.out.println(p.toString()));
        List<ProductDTO> productDTOList = new ArrayList<>();
        productFlux.toStream().forEach(p -> productDTOList.add(Client.convertProductToProductDTOForWebClients(p)));
        return productDTOList;
    }


}
