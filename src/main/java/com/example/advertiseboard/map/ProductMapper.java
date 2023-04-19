package com.example.advertiseboard.map;

import com.example.advertiseboard.entity.Product;
import com.example.advertiseboard.model.ProductCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    //@Mapping(target = "id", source = "productCreateRequest.id")
    @Mapping(target = "productName", source = "productCreateRequest.name")
    Product ProductCreateRequestToProduct(ProductCreateRequest productCreateRequest);


    @Mapping(target = "name", source = "product.productName")
    com.example.advertiseboard.model.Product ProductToModel(Product product);

}
