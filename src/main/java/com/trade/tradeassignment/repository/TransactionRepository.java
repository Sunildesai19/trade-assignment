package com.trade.tradeassignment.repository;

import com.trade.tradeassignment.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.Optional;
@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, String> {
    @Query(value="select top 1 * from TRANSACTION_MASTER t where t.trade_Id= :tradeId order by t.trade_Id desc" , nativeQuery = true)
    Optional<TransactionEntity> findByTradeId(String tradeId);
}
