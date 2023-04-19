package com.example.advertiseboard.service;

import com.example.advertiseboard.entity.Product;
import com.example.advertiseboard.exception.ProductAlreadyExistException;
import com.example.advertiseboard.exception.ProductNotFoundException;
import com.example.advertiseboard.map.ProductMapper;
import com.example.advertiseboard.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public void addProduct(com.example.advertiseboard.model.ProductCreateRequest productCreateRequest) throws ProductAlreadyExistException {
        if(productRepository.findByProductName(productCreateRequest.getName()) != null) {
            throw new ProductAlreadyExistException("Такой продукт уже существует");
        }
        var newProduct = new Product();
        //newProduct.setProductName(productCreateRequest.getName());
        newProduct = ProductMapper.INSTANCE.ProductCreateRequestToProduct(productCreateRequest);
        productRepository.save(newProduct);
    }

    public com.example.advertiseboard.model.Product getById(Long id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()) {
            throw new ProductNotFoundException("Продукт не найден");
        }
        return com.example.advertiseboard.model.Product.toModel(product.get());
    }

    public Long delete(Long id) throws ProductNotFoundException {
        if(productRepository.findById(id).isEmpty()) {
            throw new ProductNotFoundException("Продукт не найден");
        } else productRepository.deleteById(id);
        return id;
    }

    public Iterable<Product> getList() {
        return productRepository.findAll();
    }
}
