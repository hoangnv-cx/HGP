package com.spring.demo.service;

import com.spring.demo.entity.CreditCardEntity;
import com.spring.demo.model.CreditCardResponse;
import com.spring.demo.model.JobApplicationResponse;

import java.util.List;

public interface ICreditCardService {
    //crete and update card
    CreditCardEntity createAndUpdate(CreditCardEntity entity);

    List<CreditCardEntity> allCreditCard();

    //find by id
    CreditCardEntity findById(int id);

    //list card of user
    List<CreditCardEntity> cardByUser();

    //Delete card
    void deleteCardById(int card_id);

    //update type card
    void UpdatetypeCard(int id);

    //Find type card by number card
    String findTypebyNumber(String number);

    //transactionAmount
    //find card by number
    CreditCardEntity findCardBynumberCard(String number);

    CreditCardEntity convertFromResponse(CreditCardResponse response);
}
