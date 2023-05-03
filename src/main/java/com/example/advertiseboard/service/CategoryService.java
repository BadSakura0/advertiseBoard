package com.example.advertiseboard.service;

import com.example.advertiseboard.entity.Category;
import com.example.advertiseboard.exception.CategoryAlreadyExistException;
import com.example.advertiseboard.exception.CategoryNotFoundException;
import com.example.advertiseboard.exception.ProductNotFoundException;
import com.example.advertiseboard.map.CategoryMapper;
import com.example.advertiseboard.model.CategoryCreateRequest;
import com.example.advertiseboard.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    public void createCategory(CategoryCreateRequest categoryCreateRequest) throws CategoryAlreadyExistException {
        if(categoryRepository.findByCategoryName(categoryCreateRequest.getName()) != null) {
            throw new CategoryAlreadyExistException("Такая категория уже существует");
        }
        var newCategory = new Category();
        newCategory = CategoryMapper.INSTANCE.categoryCreateRequestToCategory(categoryCreateRequest);
        categoryRepository.save(newCategory);
    }

    public Iterable<Category> getProductsFromCategory(Long categoryId) {
        return categoryRepository.findAllById(Collections.singleton(categoryId));
    }

    public Iterable<Category> getCategories() {
            return categoryRepository.findAll();
        }

    public Long delete(Long id) throws CategoryNotFoundException {
        if(categoryRepository.findById(id).isEmpty()) {
            throw new CategoryNotFoundException("Категория не найдена");
        } else categoryRepository.deleteById(id);
        return id;
    }
}
