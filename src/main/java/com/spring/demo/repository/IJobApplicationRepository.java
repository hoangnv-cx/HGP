package com.spring.demo.repository;

import com.spring.demo.entity.JobApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IJobApplicationRepository extends JpaRepository<JobApplicationEntity, Integer> {
    @Transactional
    @Modifying
    @Query(value = "CALL update_Job_Applicationg_by_id_and_status(:job_id,:status_edit)", nativeQuery = true)
    void updateByIdAndStatus(@Param("job_id") int id, @Param("status_edit") byte status);

    void deleteByReJobId(int jobId);

    List<JobApplicationEntity> findByReJobId(int id);

    JobApplicationEntity findByMyWorkId(int myWorkId);
}
