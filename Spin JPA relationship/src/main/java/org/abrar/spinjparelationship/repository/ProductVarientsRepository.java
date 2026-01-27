package org.abrar.spinjparelationship.repository;

import org.abrar.spinjparelationship.entity.ProductVariants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductVarientsRepository extends JpaRepository<ProductVariants,Long> {
}
