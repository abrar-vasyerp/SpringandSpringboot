package org.abrar.spinjparelationship;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Varient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long varientId;
    private String colour;
    private String size;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(mappedBy = "varient")
    private List<StockBatch> stockBatches= Collections.emptyList();
}
