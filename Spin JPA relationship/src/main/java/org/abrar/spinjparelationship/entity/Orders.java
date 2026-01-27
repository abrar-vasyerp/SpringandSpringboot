package org.abrar.spinjparelationship.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name="order_date_time")
    private LocalDateTime orderDateAndTime=LocalDateTime.now();

    @Column(name="total_amount")
    private double totalAmount;

    @OneToMany(mappedBy ="orders", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderItem> orderItems;

}
