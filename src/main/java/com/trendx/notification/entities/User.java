package com.trendx.notification.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Document
@Service
public class User {

    @Id
    String eMail;
    String fullName;

    List<Product> followedProducts = new ArrayList<>(Arrays.asList(new Product("Bilbo", "tanim", 11334.4, 166.23), new Product("Bilbo22", "tanim22", 11334.4, 166.23)));

    public User() {

    }

    public User(String eMail, String fullName) {
        this.eMail = eMail;
        this.fullName = fullName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Product> getFollowedProducts() {
        return followedProducts;
    }

    public void setFollowedProducts(List<Product> followedProducts) {
        this.followedProducts = followedProducts;
    }

    @KafkaListener(topics = "topic", groupId = "group")
    public void listen(@Payload Product product) {
        //if (followedProducts.contains(product)){
        System.out.println(product.description + "'ın fiyatı değişti  !! !!");
        //}
    }

}

