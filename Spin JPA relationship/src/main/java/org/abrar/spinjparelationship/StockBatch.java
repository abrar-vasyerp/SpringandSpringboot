package org.abrar.spinjparelationship;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stockBatchId;
    private double quantity;
    private LocalDate expiryDate;
    private double price;

    @ManyToOne
    @JoinColumn(name = "varient_id")
    private Varient varient;
}
