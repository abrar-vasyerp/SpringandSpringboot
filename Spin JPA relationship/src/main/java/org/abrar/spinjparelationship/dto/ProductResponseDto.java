package org.abrar.spinjparelationship.dto;

import lombok.Data;

@Data
public class ProductResponseDto {

    private Long productId;
    private String productName;
    private double sellingPrice;
    private int tax;
    private Long version;
}
