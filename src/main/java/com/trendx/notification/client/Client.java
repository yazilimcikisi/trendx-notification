package com.trendx.notification.client;

import com.trendx.notification.entities.Product;
import com.trendx.notification.entities.ProductDTO;

public class Client {

    //Belki product tarafında karar verilebilir

    public static ProductDTO convertProductToProductDTOForMobileClients(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setBarcode(product.getBarcode());
        productDTO.setDescription(product.getDescription());
        productDTO.setSalesPrice(product.getMobileSalesPrice());
        return productDTO;
    }

    public static ProductDTO convertProductToProductDTOForWebClients(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setBarcode(product.getBarcode());
        productDTO.setDescription(product.getDescription());
        productDTO.setSalesPrice(product.getSalesPrice());
        return productDTO;
    }
}
