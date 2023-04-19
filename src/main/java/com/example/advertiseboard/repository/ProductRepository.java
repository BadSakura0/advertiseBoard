package com.example.advertiseboard.repository;

import com.example.advertiseboard.entity.Product;
import com.example.advertiseboard.model.ProductCreateRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByProductName(String product);
}


