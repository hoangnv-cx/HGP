package com.spring.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardResponse {

    @Schema(example = "2", type = "Integer")
    private int id;

    @Schema(example = "Nguyen Van", type = "String")
    private String firstName;

    @Schema(example = "Hau", type = "String")
    private String lastName;

    @Schema(example = "Me Tri, Ha Noi", type = "String")
    private String address;

    @Schema(example = "132415", type = "Integer")
    private int portalCode;

    @Schema(example = "20000000", type = "double")
    private double amount;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Schema(example = "12-05-1996", type = "date")
    private Date dateOfBirth;

    @Schema(example = "vanhau@gmail.com", type = "String")
    private String email;

    @Schema(example = "1", type = "Byte")
    private Byte status;

    @Schema(example = "094872012927", type = "String")
    private String accountNumber;

    @Schema(example = "123343435", type = "String")
    private String accountRouting;

    @Schema(example = "1", type = "Integer")
    private int typeID;

    @Schema(example = "1", type = "Integer")
    private int countryID;

}
