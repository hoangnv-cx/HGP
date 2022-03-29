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
@Table(name = "countrys", schema = "heroku_8824700dd65d660")
public class CountrysEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    @Schema(example = "4", type = "Integer")
    private int id;
    @Schema(example = "Nga", type = "String")
    private String name;
    @Schema(example = "0", type = "Integer")
    @Column(name = "parent_id")
    private String parentId;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
    private List<CreditCardEntity> creditCard = new ArrayList<>();

}
