package com.spring.demo.service.impl;

import com.spring.demo.entity.UsersEntity;
import com.spring.demo.entity.VisaCardEntity;
import com.spring.demo.model.VisaCardResponse;
import com.spring.demo.repository.IUserRepository;
import com.spring.demo.repository.IVisaCardRepository;
import com.spring.demo.service.IUserService;
import com.spring.demo.service.IVisaCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisaCardServiceImpl implements IVisaCardService {
    @Autowired
    private IUserService userService;
    @Autowired
    private IVisaCardRepository visaCardRepository;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<VisaCardEntity> getAllByUser() {
        UsersEntity usersEntity = userService.getByUser();
        return visaCardRepository.cardByUser(usersEntity.getId());
    }

    @Override
    public VisaCardEntity CreateandUpdateVisa(VisaCardEntity entity) {
        UsersEntity usersEntity = userService.getByUser();
        entity.setVisaUsers(usersEntity);
        return visaCardRepository.save(entity);
    }

    @Override
    public void deleteByUser(int visa_card) {
        UsersEntity usersEntity = userService.getByUser();
        VisaCardEntity visaCardEntity = visaCardRepository.findCardById(visa_card);
        if (usersEntity.getId() == visaCardEntity.getVisaUsers().getId()) {
            visaCardRepository.deleteById(visa_card);
        } else {
            throw new UsernameNotFoundException("Not found");
        }
    }

    @Override
    public VisaCardEntity findById(int id) {
        return visaCardRepository.findCardById(id);
    }

    @Override
    public void updateVisaCard(VisaCardEntity entity) {
        UsersEntity usersEntity = userService.getByUser();
        VisaCardEntity visaCardEntity = findById(entity.getId());
        UsersEntity users=userRepository.findById(visaCardEntity.getVisaUsers().getId()).orElse(null);
        if(users.getId()==usersEntity.getId()){
            entity.setVisaUsers(usersEntity);
            visaCardRepository.save(entity);
        }else
        {
            throw new UsernameNotFoundException("Not found");
        }
    }

    @Override
    public VisaCardEntity convertFromResponse(VisaCardResponse response) {
        UsersEntity usersEntity = userService.getByUser();
        VisaCardEntity visaCardEntity = new VisaCardEntity();
        visaCardEntity.setVisaUsers(usersEntity);
        visaCardEntity.setCardNumber(response.getCardNumber());
        visaCardEntity.setCvc(response.getCvc());
        visaCardEntity.setStatus(response.getStatus());
        visaCardEntity.setId(response.getId());
        visaCardEntity.setExpireDate(response.getExpireDate());
        return visaCardEntity;
    }
}
