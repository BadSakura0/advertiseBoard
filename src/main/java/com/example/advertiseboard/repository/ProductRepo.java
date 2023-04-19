package com.example.advertiseboard.repository;

import com.example.advertiseboard.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepo extends CrudRepository<ProductEntity, Long> {
    ProductEntity findByProductName(String product);
}


