package com.spring.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisaCardResponse {
    @Schema(example = "1", type = "Integer")
    private int id;

    @Schema(example = "124222", type = "String")
    private String cardNumber;

    @Schema(example = "29/10", type = "String")
    private String expireDate;

    @Schema(example = "345", type = "Integer")
    private int cvc;

    @Schema(example = "1", type = "Byte")
    private Byte status;

}
