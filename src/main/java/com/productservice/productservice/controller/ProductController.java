package com.productservice.productservice.controller;

import com.productservice.productservice.dto.ProductData;
import com.productservice.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RequestMapping("v1")
@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("v1/product-add")
    public ResponseEntity<?> productAdd(@RequestBody ProductData productData){
        ProductData result=productService.productAdd(productData);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
