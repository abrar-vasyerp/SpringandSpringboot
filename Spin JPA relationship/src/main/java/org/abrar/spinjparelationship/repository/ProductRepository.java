package org.abrar.spinjparelationship.repository;

import org.abrar.spinjparelationship.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
