package com.example.advertiseboard.controller;

import com.example.advertiseboard.entity.ProductEntity;
import com.example.advertiseboard.exception.ProductAlreadyExistException;
import com.example.advertiseboard.exception.ProductNotFoundException;
import com.example.advertiseboard.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")

public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity addProduct(@RequestBody ProductEntity product) {
        try {
            productService.addProduct(product);
            return  ResponseEntity.ok("Продукт добавлен");
        } catch (ProductAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка добавления продукта");
        }
    }

    @GetMapping
    public ResponseEntity getOneProduct(@RequestParam Long id) {
        try {
            return  ResponseEntity.ok(productService.getOne(id));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка получения продукта");
        }
    }

    @GetMapping("/list")
    public ResponseEntity getProducts() {
        try {
            return ResponseEntity.ok(productService.getList());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка получения продукта");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        try {
            return  ResponseEntity.ok(productService.delete(id));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка удаления продукта");
        }
    }
}
