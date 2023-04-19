package com.example.advertiseboard.service;

import com.example.advertiseboard.entity.ProductEntity;
import com.example.advertiseboard.exception.ProductAlreadyExistException;
import com.example.advertiseboard.exception.ProductNotFoundException;
import com.example.advertiseboard.model.Product;
import com.example.advertiseboard.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public ProductEntity addProduct(ProductEntity product) throws ProductAlreadyExistException {
        if(productRepo.findByProductName(product.getProductName()) != null) {
            throw new ProductAlreadyExistException("Такой продукт уже существует");
        }
        return productRepo.save(product);
    }

    public Product getOne(Long id) throws ProductNotFoundException {
        ProductEntity product = productRepo.findById(id).get();
        if(productRepo.findById(id).get() == null) {
            throw new ProductNotFoundException("Продукт не найден");
        }
        return Product.toModel(product);
    }

    public Long delete(Long id) throws ProductNotFoundException {
        if(productRepo.findById(id).get() == null) {
            throw new ProductNotFoundException("Продукт не найден");
        } else productRepo.deleteById(id);
        return id;
    }

    public List<ProductEntity> getList() {
        List<ProductEntity> productEntity = new ArrayList<>();
        productRepo.findAll().forEach(productEntity::add);
        return productEntity;
    }
}
