package com.example.advertiseboard.model;

import com.example.advertiseboard.map.ProductMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class Product {

    private String name;
    private String description;

    public static Product toModel(com.example.advertiseboard.entity.Product entity) {
        Product model = new Product();
        model = ProductMapper.INSTANCE.ProductToModel(entity);
        return model;
    }
}
