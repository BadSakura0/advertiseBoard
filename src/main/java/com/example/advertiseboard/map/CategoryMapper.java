package com.example.advertiseboard.map;

import com.example.advertiseboard.entity.Category;
import com.example.advertiseboard.model.CategoryCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(target = "categoryName", source = "categoryCreateRequest.name")
    Category categoryCreateRequestToCategory(CategoryCreateRequest categoryCreateRequest);

    @Mapping(target = "name", source = "category.categoryName")
    com.example.advertiseboard.model.Category categoryToModel(Category category);

}
