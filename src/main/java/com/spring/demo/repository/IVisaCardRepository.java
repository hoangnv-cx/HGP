package com.spring.demo.repository;

import com.spring.demo.entity.VisaCardEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVisaCardRepository extends CrudRepository<VisaCardEntity, Integer> {
    @Query(value = "Select * from visa_card where user_id=:userid", nativeQuery = true)
    List<VisaCardEntity> cardByUser(@Param("userid") int userid);

    //delete card by id
    @Query(value = "select * from visa_card where id=:visaId", nativeQuery = true)
    VisaCardEntity findCardById(@Param("visaId") int visaId);
}
