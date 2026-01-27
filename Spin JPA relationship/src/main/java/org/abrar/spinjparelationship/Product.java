package org.abrar.spinjparelationship;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String productName;
    private int tax;
    private double sellingPrice;
    private boolean isDeleted;
    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;

    @OneToMany(mappedBy = "product")
    private List<Varient> varients= Collections.emptyList();

}
