package org.abrar.spinjparelationship.repository;

import org.abrar.spinjparelationship.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

    @Query("SELECT p, SUM(oi.quantity) AS soldQuantity FROM OrderItem oi JOIN oi.productVariants v JOIN v.product p JOIN oi.orders o WHERE o.orderDateAndTime >= :dateAndTime GROUP BY p ORDER BY soldQuantity DESC")
    List<Object[]> findTopSellingProducts(@Param("dateAndTime") LocalDateTime fromDateAndTime);
}

