package com.spring.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class StatusResponse {
    @Schema(example = "4", type = "Integer")
    private int entityId;
    @Schema(example = "1", type = "String", format = "byte")
    private byte status;
}
