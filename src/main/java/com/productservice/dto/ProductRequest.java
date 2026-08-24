package com.productservice.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    @NotBlank(message = "Product name is required")
    @Size(min = 3, max = 100,
            message = "Product name must be between 3 and 100 characters")
    private String product_name;

    @NotBlank(message = "Description is required")
    @Size(max = 500,
            message = "Description cannot exceed 500 characters")
    private String description;

    @NotBlank(message = "Category is required")
    @Size(max = 50,
            message = "Category cannot exceed 50 characters")
    private String category;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01",
            message = "Price must be greater than 0")
    private BigDecimal price;

    @NotNull(message = "Quantity is required")
    @Min(value = 0,
            message = "Quantity cannot be negative")
    private Integer quantity;
}