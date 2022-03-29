package com.spring.demo.service.impl;

import com.spring.demo.entity.CreditCardEntity;
import com.spring.demo.entity.UsersEntity;
import com.spring.demo.model.CreditCardResponse;
import com.spring.demo.repository.ICreditCardRepository;
import com.spring.demo.service.ICountryService;
import com.spring.demo.service.ICreditCardService;
import com.spring.demo.service.ITypeService;
import com.spring.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardServiceImpl implements ICreditCardService {
    @Autowired
    private ICreditCardRepository creditCardPepository;
    @Autowired
    private IUserService userService;
    @Autowired
    private ITypeService typeService;
    @Autowired
    private ICountryService countryService;


    @Override
    public CreditCardEntity createAndUpdate(CreditCardEntity entity) {
        UsersEntity usersEntity = userService.getByUser();
        entity.setCreditUser(usersEntity);
        entity.setCountry(entity.getCountry());
        entity.setType(entity.getType());
        return creditCardPepository.save(entity);
    }

    @Override
    public List<CreditCardEntity> allCreditCard() {
        return (List<CreditCardEntity>) creditCardPepository.findAll();
    }

    @Override
    public CreditCardEntity findById(int id) {
        return creditCardPepository.findCardById(id);
    }

    @Override
    public List<CreditCardEntity> cardByUser() {
        UsersEntity usersEntity = userService.getByUser();
        return creditCardPepository.cardByUser(usersEntity.getId());
    }


    @Override
    public String findTypebyNumber(String number) {

        return creditCardPepository.findTypeBynumberCard(number);
    }

    @Override
    public CreditCardEntity findCardBynumberCard(String number) {
        return creditCardPepository.findCardBynumberCard(number);
    }

    @Override
    public CreditCardEntity convertFromResponse(CreditCardResponse response) {
        CreditCardEntity creditCardEntity = new CreditCardEntity();

        UsersEntity usersEntity = userService.getByUser();
        creditCardEntity.setCreditUser(usersEntity);
        creditCardEntity.setId(response.getId());
        creditCardEntity.setAddress(response.getAddress());
        creditCardEntity.setAccountNumber(response.getAccountNumber());
        creditCardEntity.setAccountRouting(response.getAccountRouting());
        creditCardEntity.setEmail(response.getEmail());
        creditCardEntity.setAmount(response.getAmount());
        creditCardEntity.setDateOfBirth(response.getDateOfBirth());
        creditCardEntity.setStatus(response.getStatus());
        creditCardEntity.setFirstName(response.getFirstName());
        creditCardEntity.setLastName(response.getLastName());
        creditCardEntity.setType(typeService.findById(response.getTypeID()));
        creditCardEntity.setCountry(countryService.findById(response.getCountryID()));
        return creditCardEntity;
    }

    @Override
    public void deleteCardById(int card_id) {
        UsersEntity usersEntity = userService.getByUser();
        CreditCardEntity creditCardEntity = creditCardPepository.findCardById(card_id);
        if (creditCardEntity.getCreditUser().getId() == (usersEntity.getId())) {
            creditCardPepository.deleteById(card_id);
        } else {
            throw new UsernameNotFoundException("Access Denined");
        }
    }

    @Override
    public void UpdatetypeCard(int id) {
        creditCardPepository.updateType(id);
    }
    //transactionAmount
    //find credit card by number


}
