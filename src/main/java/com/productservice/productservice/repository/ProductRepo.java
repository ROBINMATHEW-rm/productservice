package com.productservice.productservice.repository;

import com.productservice.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Integer, Product> {
}
