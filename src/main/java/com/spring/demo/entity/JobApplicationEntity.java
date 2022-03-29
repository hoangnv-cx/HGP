package com.spring.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_application", schema = "heroku_8824700dd65d660")
public class JobApplicationEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    @Schema(example = "34", type = "Integer")
    private int id;
    @Column(name = "my_bid")
    @Schema(example = "2300", type = "double")
    private double myBid;
    @Schema(example = "Xin chao, toi muon nhan cong viec cua ban", type = "String")
    private String description;
    @Column(name = "file_name")
    @Schema(example = "1618219444140_Nguyen-Ba-Phuc-TopCV.vn-080321.85451.pdf", type = "String")
    private String fileName;
    @Schema(hidden = true)
    private byte status;

    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    private JobPostingEntity reJob;

    @Schema(hidden = true)
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UsersEntity usersJobApplication;

    @JsonIgnore
    @OneToOne(mappedBy = "jobApplication")
    private MyWorkEntity myWork;

}
