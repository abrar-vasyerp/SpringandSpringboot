package org.abrar.spinjparelationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name="product_name")
    private String productName;

    @Column(name="tax")
    private int tax;

    @Column(name="selling_price")
    private double sellingPrice;

    @Column(name="is_deleted")
    private boolean isDeleted;

    @Column(name="created_on")
    private LocalDateTime createdOn;

    @Column(name="modified_on")
    private LocalDateTime modifiedOn;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ProductVariants> productVariants;

}
