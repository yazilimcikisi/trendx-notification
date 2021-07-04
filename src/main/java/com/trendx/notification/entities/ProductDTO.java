package com.trendx.notification.entities;

public class ProductDTO {
    String barcode;
    String description;
    Double salesPrice;

    public ProductDTO() {
    }

    public ProductDTO(String barcode, String description, Double salesPrice) {
        this.barcode = barcode;
        this.description = description;
        this.salesPrice = salesPrice;
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
}

