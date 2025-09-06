package com.productservice.productservice.assembler;

import com.productservice.productservice.dto.ProductData;
import com.productservice.productservice.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductAssembler {
    //    public Product assembleCreateSchemeData(ProductData productData){
//        return Product.builder()
//                .name(productData.getProductName())
//                .price(productData.getProductPrice())
//                .build();
//    }
public Product dtoToEntity(ProductData productData){
    Product product = new Product();
    product.setName(productData.getProductName());
    product.setPrice(productData.getProductPrice());
    return product;
}
    public ProductData entityToDto(Product product){
        ProductData productData = new ProductData();
        product.setName(productData.getProductName());
        product.setPrice(productData.getProductPrice());
        return productData;
    }
    public List<ProductData> toDtoList(List<Product> productList){
        return productList.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
