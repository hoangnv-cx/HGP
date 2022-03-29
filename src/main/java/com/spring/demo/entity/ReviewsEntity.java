package com.spring.demo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews", schema = "heroku_8824700dd65d660")
public class ReviewsEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    @Schema(example = "4", type = "Integer")
    private int id;
    @Schema(example = "Good", type = "String")
    private String comment;
    @Min(value = 0, message = "Rate can not less than 0!")
    @Max(value = 5, message = "Rate can not greater than 5!")
    @Schema(example = "4", type = "Integer")
    private Integer rate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empl_id", referencedColumnName = "id")
    private UsersEntity employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "custom_id", referencedColumnName = "id")
    private UsersEntity custom;


}
