package com.example.advertiseboard.repository;

import com.example.advertiseboard.entity.Category;
import com.example.advertiseboard.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findByCategoryName(String category);
}
