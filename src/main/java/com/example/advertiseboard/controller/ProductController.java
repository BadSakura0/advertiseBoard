package com.example.advertiseboard.controller;

import com.example.advertiseboard.exception.ProductAlreadyExistException;
import com.example.advertiseboard.exception.ProductNotFoundException;
import com.example.advertiseboard.model.ProductCreateRequest;
import com.example.advertiseboard.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")

public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity addProduct(@RequestBody ProductCreateRequest productCreateRequest, @RequestParam Long categoryId) {
        try {
            productService.addProduct(productCreateRequest, categoryId);
            return ResponseEntity.ok("Продукт добавлен");
        } catch (ProductAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка добавления продукта");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(productService.getById(id));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка получения продукта");
        }
    }

    @GetMapping("/")
    public ResponseEntity getProducts() {
        try {
            return ResponseEntity.ok(productService.getProducts());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка получения продукта");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(productService.delete(id));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка удаления продукта");
        }
    }
}
