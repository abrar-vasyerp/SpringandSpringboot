package org.abrar.spinjparelationship.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product_variant")
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "variant_id")
    private Long variantId;

    @Column(name="variant_name")
    private String variantName;

    @Column(name="selling_price")
    private double sellingPrice;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties("productVariants")
    private Product product;

    @OneToMany(mappedBy = "productVariant",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<StockMaster> stockMasters ;
}
