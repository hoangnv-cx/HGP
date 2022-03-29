package com.spring.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryResponse {
    @Schema(example = "4", type = "Integer")
    private int id;

    @Schema(example = "Nga", type = "String")
    private String name;

    @Schema(example = "0", type = "Integer")
    private String parentId;

}
