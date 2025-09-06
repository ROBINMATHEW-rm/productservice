package com.productservice.productservice.assembler;

import com.productservice.productservice.dto.ProductData;
import com.productservice.productservice.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductAssembler {
    public Product assembleCreateSchemeData(ProductData productData){
        return Product.builder()
                .name(productData.getProductName())
                .price(productData.getProductPrice())
                .build();
    }
}
