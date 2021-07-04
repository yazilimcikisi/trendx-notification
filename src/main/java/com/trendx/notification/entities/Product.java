package com.trendx.notification.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class Product {

    @Id
    String barcode;

    String description;

    Double salesPrice;

    Double mobileSalesPrice;
    //private List<User> subscribers = new ArrayList<>();

    public Product() {
    }

    public Product(String barcode, String description, Double salesPrice, Double mobileSalesPrice) {
        this.barcode = barcode;
        this.description = description;
        this.salesPrice = salesPrice;
        this.mobileSalesPrice = mobileSalesPrice;

    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public Double getMobileSalesPrice() {
        return mobileSalesPrice;
    }

    public void setMobileSalesPrice(Double mobileSalesPrice) {
        this.mobileSalesPrice = mobileSalesPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "barcode='" + barcode + '\'' +
                ", description='" + description + '\'' +
                ", salesPrice=" + salesPrice +
                ", mobileSalesPrice=" + mobileSalesPrice +
                '}';
    }

}

