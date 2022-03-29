package com.spring.demo.repository;

import com.spring.demo.entity.TransactionAmountEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransactionAmountRepository extends CrudRepository<TransactionAmountEntity, Integer> {
    @Query(value = "Select * from transactions where card_received=:id or card_send=:id", nativeQuery = true)
    List<TransactionAmountEntity> transactionByUser(@Param("id") int id);
}
