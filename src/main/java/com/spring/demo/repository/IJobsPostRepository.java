package com.spring.demo.repository;

import com.spring.demo.entity.JobPostingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface IJobsPostRepository extends JpaRepository<JobPostingEntity, Integer> {

    List<JobPostingEntity> findByLatAndLon(String lat, String lon);

    List<JobPostingEntity> findByTitle(String title);

    List<JobPostingEntity> findByCategoryId(int cate_id);

    @Transactional
    @Modifying
    @Query(value = "CALL update_job_posting_by_id_and_status(:job_id,:status_edit)", nativeQuery = true)
    void updateByIdAndStatus(@Param("job_id") int id, @Param("status_edit") byte status);

    @Query(value = "CALL find_job_by_wish_list(:cate_id)", nativeQuery = true)
    List<JobPostingEntity> findWishlistJobs(@Param("cate_id") int cateId);

    @Query(value = "CALL find_job_by_price(:f_price, :l_price,:s_date)", nativeQuery = true)
    List<JobPostingEntity> findByPrice(@Param("f_price") double fPrice, @Param("l_price") double lPrice, @Param("s_date") Date date);


}
