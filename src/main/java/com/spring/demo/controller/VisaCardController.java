package com.spring.demo.controller;

import com.spring.demo.entity.CreditCardEntity;
import com.spring.demo.entity.VisaCardEntity;
import com.spring.demo.model.VisaCardResponse;
import com.spring.demo.service.IVisaCardService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Tag(name = "Visa Card Api")
public class VisaCardController {
    @Autowired
    private IVisaCardService visaCardService;

    @GetMapping(value = "/visa")
    public List<VisaCardEntity> getAllByUser() {
        return visaCardService.getAllByUser();
    }

    @PostMapping(value = "/visa")
    public VisaCardEntity CrateNewVisa(@RequestBody VisaCardResponse response) {
        VisaCardEntity visaCardEntity = visaCardService.convertFromResponse(response);
        return visaCardService.CreateandUpdateVisa(visaCardEntity);
    }

    @DeleteMapping(value = "/visa/delete/{id}")
    public void DeleteByUser(@PathVariable int id) {
        visaCardService.deleteByUser(id);
    }

    @GetMapping(value="/visa/{id}")
    public VisaCardEntity findByID(@PathVariable("id") int id){
        return visaCardService.findById(id);
    }

    @PutMapping(value = "/visa/update")
    public void updateVisaCard(@RequestBody VisaCardResponse response) {
        VisaCardEntity visaCardEntity = visaCardService.convertFromResponse(response);
        visaCardService.updateVisaCard(visaCardEntity);
    }
}
