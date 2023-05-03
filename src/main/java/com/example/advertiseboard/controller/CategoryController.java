package com.example.advertiseboard.controller;

import com.example.advertiseboard.exception.CategoryAlreadyExistException;
import com.example.advertiseboard.exception.CategoryNotFoundException;
import com.example.advertiseboard.exception.ProductNotFoundException;
import com.example.advertiseboard.model.CategoryCreateRequest;
import com.example.advertiseboard.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity createCategory(@RequestBody CategoryCreateRequest categoryCreateRequest) {
        try {
            categoryService.createCategory(categoryCreateRequest);
            return  ResponseEntity.ok("Категория добавлена");
        } catch (CategoryAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка добавления категории");
        }
    }

    @GetMapping("/")
    public ResponseEntity getCategories() {
        try {
            return ResponseEntity.ok(categoryService.getCategories());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка получения продукта");
        }
    }

    @GetMapping()
    public ResponseEntity getProductsFromCategory(@RequestParam Long categoryId) {
        try {
            return ResponseEntity.ok(categoryService.getProductsFromCategory(categoryId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка вывода продуктов категории");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(categoryService.delete(id));
        } catch (CategoryNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка удаления продукта");
        }
    }
}
