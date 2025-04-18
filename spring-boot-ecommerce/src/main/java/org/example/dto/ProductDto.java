package org.example.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {

    // Auto generated, no validations needed
    private String productId;
    // Cannot be blank
    @NotBlank(message = "Product name cannot be left blank.")
    private String productName;
    // Cannot be 0
    @Min(value = 1, message = "Price cannot be zero.")
    private double price;
    // Cannot be zero
    @Min(value = 1, message = "Stock cannot be zero.")
    private int stock;

    public ProductDto(String productName, double price, int stock) {
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }
}
