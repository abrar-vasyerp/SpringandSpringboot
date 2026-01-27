package org.abrar.spinjparelationship.repository;

import org.abrar.spinjparelationship.entity.StockMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockMasterRepository extends JpaRepository<StockMaster,Long> {
}
