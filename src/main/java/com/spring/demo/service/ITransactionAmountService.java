package com.spring.demo.service;

import com.spring.demo.entity.TransactionAmountEntity;

import java.util.List;

public interface ITransactionAmountService {
    TransactionAmountEntity addAndUpdate(TransactionAmountEntity entity);

    List<TransactionAmountEntity> AllTransactionByUser(int id);
}
