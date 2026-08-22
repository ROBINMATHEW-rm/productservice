package com.productservice.service;

import com.productservice.dto.ApiResponse;
import com.productservice.exception.ProductNotFoundException;
import com.productservice.dto.ProductRequest;
import com.productservice.dto.ProductResponse;
import com.productservice.entity.Product;
import com.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest request) {

        Product product = new Product();

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setCategory(request.getCategory());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());

        Product savedProduct = productRepository.save(product);

        return mapToResponse(savedProduct);
    }

    public List<ProductResponse> getAllProducts() {

        return productRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public ProductResponse getProductById(String id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException(
                                "Product not found with id: " + id));

        return mapToResponse(product);
    }

    public ApiResponse deleteProduct(String id) {

        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(
                    "Product not found with id: " + id);
        }

        productRepository.deleteById(id);

        return new ApiResponse("Product deleted successfully");
    }

    private ProductResponse mapToResponse(Product product) {

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getCategory(),
                product.getPrice(),
                product.getQuantity()
        );
    }
}