package com.example.advertiseboard.map;

import com.example.advertiseboard.entity.Product;
import com.example.advertiseboard.model.ProductCreateRequest;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "productName", source = "productCreateRequest.name")
    Product productCreateRequestToProduct(ProductCreateRequest productCreateRequest);


    @Mapping(target = "name", source = "product.productName")
    com.example.advertiseboard.model.Product productToModel(Product product);

}
