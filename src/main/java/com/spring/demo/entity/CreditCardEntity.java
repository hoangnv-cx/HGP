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
@Table(name = "credit_card", schema = "heroku_8824700dd65d660")
public class CreditCardEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    @Schema(example = "2", type = "Integer")
    private int id;
    @Column(name = "first_name")
    @Schema(example = "Nguyen Van", type = "String")
    private String firstName;
    @Column(name = "last_name")
    @Schema(example = "Hau", type = "String")
    private String lastName;
    @Schema(example = "Me Tri, Ha Noi", type = "String")
    private String address;
    @Column(name = "portal_code")
    @Schema(example = "132415", type = "Integer")
    private int portalCode;
    @Column(name = "amount")
    @Schema(example = "20000000", type = "double")
    private double amount;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date_of_birth")
    @Schema(example = "12-05-1996")
    private Date dateOfBirth;
    @Schema(example = "vanhau@gmail.com", type = "String")
    private String email;
    @Schema(example = "1", type = "Byte")
    private Byte status;
    @Column(name = "account_number", unique = true)
    @Schema(example = "094872012927", type = "String")
    private String accountNumber;
    @Column(name = "account_routing")
    @Schema(example = "123343435", type = "String")
    private String accountRouting;

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private TypesEntity type;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private CountrysEntity country;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UsersEntity creditUser;

    @JsonIgnore
    @OneToMany(mappedBy = "cardReceived")
    private List<TransactionAmountEntity> ReceivedAmount = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "cardSend")
    private List<TransactionAmountEntity> SendAmount = new ArrayList<>();

}
