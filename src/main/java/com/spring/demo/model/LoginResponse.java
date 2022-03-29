package com.spring.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    @Schema(example = "Admin")
    private String userName;
    @Schema(example = "123456")
    private String passWord;
}
