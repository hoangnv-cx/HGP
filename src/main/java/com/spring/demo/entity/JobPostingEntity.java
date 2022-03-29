package com.spring.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_posting", schema = "heroku_8824700dd65d660")
public class JobPostingEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    @Schema(example = "4", type = "Integer")
    private int id;
    @Schema(example = "Java Developer", type = "String")
    private String title;
    @Column(name = "first_price")
    @Schema(example = "2000", type = "double")
    private double firstPrice;
    @Column(name = "last_price")
    @Schema(example = "3000", type = "double")
    private double lastPrice;
    @Schema(example = "Hiring Developer Java Full-Stack", type = "String")
    private String content;
    @Schema(example = "104", type = "String")
    private String lat;
    @Schema(example = "203", type = "String")
    private String lon;
    @Schema(hidden = true)
    private byte status;
    @Column(name = "time_remating")
    @Schema(example = "2021-04-21T09:14:14.110Z")
    private Date timeRemating;
    @Schema(hidden = true)
    @Column(name = "created_at")
    private Date createdAt;

    @Schema(hidden = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UsersEntity jobPostUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoriesEntity category;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reJob")
    private List<JobApplicationEntity> jobApplications = new ArrayList<>();


}
