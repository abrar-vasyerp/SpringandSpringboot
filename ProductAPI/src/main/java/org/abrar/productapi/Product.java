package org.abrar.productapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int productId;
    private String productName;
    private int tax;
    private double sellingPrice;
    private double costPrice;
    private boolean isDeleted;
    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;
}
