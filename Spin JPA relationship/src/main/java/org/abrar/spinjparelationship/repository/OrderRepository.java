package org.abrar.spinjparelationship.repository;

import org.abrar.spinjparelationship.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Orders, Long> {


}
