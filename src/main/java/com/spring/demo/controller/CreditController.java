package com.spring.demo.controller;

import com.spring.demo.entity.CreditCardEntity;
import com.spring.demo.model.CreditCardResponse;
import com.spring.demo.model.MessageModel;
import com.spring.demo.service.ICreditCardService;
import com.spring.demo.service.IMessagesService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Tag(name = "Credit Api")
public class CreditController {
    @Autowired
    private ICreditCardService creditCardService;

    @PostMapping(value = "/credit")
    public CreditCardEntity addCreditCard(@RequestBody CreditCardResponse response) {
        CreditCardEntity creditCardEntity = creditCardService.convertFromResponse(response);
        return creditCardService.createAndUpdate(creditCardEntity);
    }

    @PutMapping(value = "/credit")
    public CreditCardEntity updateCreditCard(@RequestBody CreditCardResponse response) {
        CreditCardEntity creditCardEntity = creditCardService.convertFromResponse(response);
        return creditCardService.createAndUpdate(creditCardEntity);
    }

    @GetMapping(value = "/mycredit")
    public List<CreditCardEntity> AllCardByName() {
        return creditCardService.cardByUser();
    }

    @DeleteMapping(value = "/credit/delete/{id}")
    public void deleteCard(@PathVariable("id") Integer id) {
        creditCardService.deleteCardById(id);
    }

    @GetMapping(value = "/credit/cardID/{id}")
    public CreditCardEntity findByID(@PathVariable("id") int id) {
        return creditCardService.findById(id);
    }

    @PutMapping(value = "/credit/update/typecard/{id}")
    public void updatetypeCard(@PathVariable("id") int id) {
        creditCardService.UpdatetypeCard(id);
    }

    //Get type card by number card
    @GetMapping(value = "/credit/number/{number}")
    public String findbyNumberCard(@PathVariable("number") String number) {
        return creditCardService.findTypebyNumber(number);
    }
    //transaction Amount
    //Get credit card by number card
    @GetMapping(value = "/credit/transaction/{number}")
    public CreditCardEntity findCardbyNumberCard(@PathVariable("number") String number) {
        return creditCardService.findCardBynumberCard(number);
    }
}
