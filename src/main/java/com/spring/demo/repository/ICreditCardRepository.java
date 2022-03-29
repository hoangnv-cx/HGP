package com.spring.demo.repository;

import com.spring.demo.entity.CreditCardEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ICreditCardRepository extends CrudRepository<CreditCardEntity, Integer> {

    @Query(value = "Select * from credit_card where user_id=:userid", nativeQuery = true)
    List<CreditCardEntity> cardByUser(@Param("userid") int userid);

    //Update credit card to Bussiness
    @Modifying
    @Transactional
    @Query(value = "update credit_card set type_id=2, amount=(amount-5) where id=:id", nativeQuery = true)
    void updateType(@Param("id") int id);
    //-----------

    //delete card by id
    @Query(value = "select * from credit_card where id=:carId", nativeQuery = true)
    CreditCardEntity findCardById(@Param("carId") int carId);

    //find type card by number
    @Query(value = "select name from types where id in(select type_id from credit_card where account_number =:account_number)", nativeQuery = true)
    String findTypeBynumberCard(@Param("account_number") String account_number);

    //find credit card by number
    @Query(value = "select * from credit_card where account_number=:account_number", nativeQuery = true)
    CreditCardEntity findCardBynumberCard(@Param("account_number") String account_number);

    //update card


}
