package com.spring.demo.controller;

import com.spring.demo.entity.TransactionAmountEntity;
import com.spring.demo.service.ITransactionAmountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(consumes = "application/json")
@Tag(name = "Transaction Api")
public class TransactionAmountController {
    @Autowired
    private ITransactionAmountService transactionAmountService;

    @PostMapping(value = "/transaction")
    public TransactionAmountEntity addTransaction(@RequestBody TransactionAmountEntity entity) {
        return transactionAmountService.addAndUpdate(entity);
    }

    @GetMapping(value = "/transaction/{card_id}")
    public List<TransactionAmountEntity> transactionByUser(@PathVariable("card_id") int card_id) {
        return transactionAmountService.AllTransactionByUser(card_id);
    }

}
