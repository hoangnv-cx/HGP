package com.spring.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MyWordResponse {
    @Schema(example = "44", type = "Integer")
    private int jobApplicationId;
    @Schema(example = "1", type = "String", format = "byte")
    private byte status;
}
