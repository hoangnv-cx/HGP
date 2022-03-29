package com.spring.demo.service;

import com.spring.demo.entity.CreditCardEntity;
import com.spring.demo.entity.VisaCardEntity;
import com.spring.demo.model.CreditCardResponse;
import com.spring.demo.model.VisaCardResponse;

import java.util.List;

public interface IVisaCardService {
    List<VisaCardEntity> getAllByUser();
    VisaCardEntity CreateandUpdateVisa(VisaCardEntity entity);

    void deleteByUser(int visa_card);

    VisaCardEntity findById(int id);
    void updateVisaCard(VisaCardEntity entity);
    VisaCardEntity convertFromResponse(VisaCardResponse response);
}
