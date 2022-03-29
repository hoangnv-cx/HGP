package com.spring.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories", schema = "heroku_8824700dd65d660")
public class CategoriesEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    @Schema(example = "4", type = "Integer")
    private int id;
    @Schema(example = "Developer", type = "String")
    private String name;
    @Schema(example = "C0012", type = "String")
    private String code;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<JobPostingEntity> jobPosting = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "mySkills", fetch = FetchType.LAZY)
    private List<UsersEntity> users = new ArrayList<>();
}
