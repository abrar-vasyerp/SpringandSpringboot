package org.abrar.spinjparelationship.repository;

import org.abrar.spinjparelationship.entity.StockBatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockBatchRepository extends JpaRepository<StockBatch,Long> {
}
