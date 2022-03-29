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
@Table(name = "visa_card", schema = "heroku_8824700dd65d660")
public class VisaCardEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    @Schema(example = "1", type = "Integer")
    private int id;
    @Column(name = "card_number")
    @Schema(example = "124222", type = "String")
    private String cardNumber;

    @Column(name = "expire_date")
    @Schema(example = "29/10", type = "String")
    private String expireDate;
    @Schema(example = "345", type = "Integer")
    private int cvc;
    @Schema(example = "1", type = "Byte")
    private Byte status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UsersEntity visaUsers;
}
