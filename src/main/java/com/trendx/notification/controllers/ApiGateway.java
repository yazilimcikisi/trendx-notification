package com.trendx.notification.controllers;

import com.trendx.notification.entities.ProductDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ApiGateway {

    @GetMapping
    public List<ProductDTO> getAllProducts(@RequestHeader("mobile-web") String type) {
        WebClient webClient = WebClient.create();
        String uri = "localhost:8080/products/type";
        List<ProductDTO> productList = webClient.get().uri(UriBuilder ->
                UriBuilder.path(uri).queryParam("type", type).build()).
                retrieve().bodyToFlux(ProductDTO.class).collectList().block();
        return productList;
    }


}
