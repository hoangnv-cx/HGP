package com.spring.demo.service.impl;

import com.spring.demo.entity.TransactionAmountEntity;
import com.spring.demo.repository.ITransactionAmountRepository;
import com.spring.demo.service.ICreditCardService;
import com.spring.demo.service.ITransactionAmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionAmountServiceImpl implements ITransactionAmountService {
    @Autowired
    private ITransactionAmountRepository transactionAmountRepository;
    @Autowired
    private ICreditCardService cardService;

    @Override
    public TransactionAmountEntity addAndUpdate(TransactionAmountEntity entity) {
        return transactionAmountRepository.save(entity);
    }

    @Override
    public List<TransactionAmountEntity> AllTransactionByUser(int id) {
        return transactionAmountRepository.transactionByUser(id);
    }
}
