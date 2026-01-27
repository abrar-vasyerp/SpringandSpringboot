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
@Table(name="stock_master")
public class StockMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockBatchId;

    @Column(name="quantity")
    private double quantity;

    @Column(name="expiry_date")
    private LocalDate expiryDate;

    @Column(name="buying_price")
    private double buyingPrice;

    @Column(name="batch_number")
    private String batchNumber;

    @ManyToOne
    @JoinColumn(name = "product_variants_id")
    private ProductVariants productVariants;
}
