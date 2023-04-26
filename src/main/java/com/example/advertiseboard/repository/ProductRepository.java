package com.example.advertiseboard.repository;

import com.example.advertiseboard.entity.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByProductName(String product);
}


