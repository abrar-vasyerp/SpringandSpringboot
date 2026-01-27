package org.abrar.spinjparelationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Varient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long varientId;
    private String colour;
    private String size;
    private double sellingPrice;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(mappedBy = "varient",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<StockBatch> stockBatches= new ArrayList<>();
}
