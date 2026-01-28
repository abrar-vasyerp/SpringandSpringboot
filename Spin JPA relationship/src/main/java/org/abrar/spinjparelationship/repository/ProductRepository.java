package org.abrar.spinjparelationship.repository;

import org.abrar.spinjparelationship.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Modifying
    @Transactional
    @Query("update Product p set p.isDeleted=true where p.productId=:id")
    int softDeleteProductByProductId(@Param("id") Long productId);
}
