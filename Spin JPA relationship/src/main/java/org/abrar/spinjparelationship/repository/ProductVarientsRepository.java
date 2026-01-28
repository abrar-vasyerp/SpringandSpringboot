package org.abrar.spinjparelationship.repository;

import org.abrar.spinjparelationship.entity.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductVarientsRepository extends JpaRepository<ProductVariant,Long> {
}
