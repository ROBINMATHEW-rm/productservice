package com.productservice.controller;

import com.productservice.dto.ApiResponse;
import com.productservice.dto.ProductRequest;
import com.productservice.dto.ProductResponse;
import com.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(
            @Valid @RequestBody ProductRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.createProduct(request));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(
            @PathVariable String id) {

        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ProductResponse> getProductByName(
            @PathVariable String name) {

        return ResponseEntity.ok(
                productService.getProductByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(
            @PathVariable String id) {

        ApiResponse response = productService.deleteProduct(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}