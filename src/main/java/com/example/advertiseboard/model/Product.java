package com.example.advertiseboard.model;

import com.example.advertiseboard.map.ProductMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class Product {

    private String name;

    public Product() { }

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Product toModel(com.example.advertiseboard.entity.Product entity) {
        Product model = new Product();
        //model.setName(entity.getProductName());
        model = ProductMapper.INSTANCE.ProductToModel(entity);
        return model;
    }
}
