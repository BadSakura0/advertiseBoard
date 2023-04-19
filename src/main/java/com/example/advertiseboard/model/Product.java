package com.example.advertiseboard.model;

import com.example.advertiseboard.entity.ProductEntity;

public class Product {
    //private Long id;
    private String productName;

    public static Product toModel(ProductEntity entity) {
        Product model = new Product();
        //model.setId(entity.getId());
        model.setProductName(entity.getProductName());
        return model;
    }

    public Product() {
    }

    //public Long getId() {
    //    return id;
    //}

    //public void setId(Long id) {
    //    this.id = id;
    //}

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
