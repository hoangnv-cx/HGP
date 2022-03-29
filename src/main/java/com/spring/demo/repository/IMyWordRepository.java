package com.spring.demo.repository;

import com.spring.demo.entity.MyWorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IMyWordRepository extends JpaRepository<MyWorkEntity, Integer> {

    @Transactional
    @Modifying
    @Query(value = "CALL update_my_word_by_id_and_status(:job_id,:status_edit)", nativeQuery = true)
    void updateByIdAndStatus(@Param("job_id") int id, @Param("status_edit") byte status);

    void deleteByJobApplicationId(int jobAppId);
}
