package com.example.advertiseboard.service;

import com.example.advertiseboard.entity.Category;
import com.example.advertiseboard.entity.Product;
import com.example.advertiseboard.exception.ProductAlreadyExistException;
import com.example.advertiseboard.exception.ProductNotFoundException;
import com.example.advertiseboard.map.ProductMapper;
import com.example.advertiseboard.model.ProductCreateRequest;
import com.example.advertiseboard.repository.CategoryRepository;
import com.example.advertiseboard.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    public void addProduct(ProductCreateRequest productCreateRequest, Long categoryId) throws ProductAlreadyExistException {
        if (productRepository.findByProductName(productCreateRequest.getName()) != null) {
            throw new ProductAlreadyExistException("Такой продукт уже существует");
        }
        var newProduct = new Product();
        newProduct = ProductMapper.INSTANCE.productCreateRequestToProduct(productCreateRequest);
        Category category = categoryRepository.findById(categoryId).get();
        newProduct.setCategory(category);
        productRepository.save(newProduct);
    }

    public com.example.advertiseboard.model.Product getById(Long id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException("Продукт не найден");
        }
        return ProductMapper.INSTANCE.productToModel(product.get());
    }

    public Long delete(Long id) throws ProductNotFoundException {
        if(productRepository.findById(id).isEmpty()) {
            throw new ProductNotFoundException("Продукт не найден");
        } else productRepository.deleteById(id);
        return id;
    }

    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }
}
