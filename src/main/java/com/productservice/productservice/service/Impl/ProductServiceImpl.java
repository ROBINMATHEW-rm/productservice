package com.productservice.productservice.service.Impl;

import com.productservice.productservice.assembler.ProductAssembler;
import com.productservice.productservice.dto.ProductData;
import com.productservice.productservice.entity.Product;
import com.productservice.productservice.repository.ProductRepo;
import com.productservice.productservice.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductAssembler productAssembler;
    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductAssembler productAssembler, ProductRepo productRepo) {
        this.productAssembler = productAssembler;
        this.productRepo = productRepo;
    }

    @Override
    public ProductData productAdd(ProductData productData){
        Product result = productRepo.save(productAssembler.dtoToEntity(productData));
        return productAssembler.entityToDto(result);
    }
}
