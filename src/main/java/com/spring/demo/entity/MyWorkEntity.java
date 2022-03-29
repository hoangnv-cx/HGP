package com.spring.demo.entity;

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
@Table(name = "my_work", schema = "heroku_8824700dd65d660")
public class MyWorkEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    @Schema(example = "4", type = "Integer")
    private int id;
    @Schema(hidden = true)
    private byte status;

    @OneToOne
    @JoinColumn(name = "job_app_id", referencedColumnName = "id")
    private JobApplicationEntity jobApplication;
}
