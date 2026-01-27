package org.abrar.spinjparelationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockBatchId;
    private double quantity;
    private LocalDate expiryDate;
    private double buyingPrice;
    private String batchNumber;

    @ManyToOne
    @JoinColumn(name = "varient_id")
    private Varient varient;
}
