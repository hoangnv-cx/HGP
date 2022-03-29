package com.spring.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.sql.Date;

@Data
public class JobsPostResponse {
    @Schema(example = "Java Developer", type = "String")
    private String title;
    @Schema(example = "2000", type = "double")
    private double firstPrice;
    @Schema(example = "3000", type = "double")
    private double lastPrice;
    @Schema(example = "Hiring Developer Java Full-Stack", type = "String")
    private String content;
    @Schema(example = "104", type = "String")
    private String lat;
    @Schema(example = "203", type = "String")
    private String lon;
    @Schema(example = "2021-04-21T09:14:14.110Z")
    private Date timeRemating;
    @Schema(example = "4", type = "Integer")
    private int cateId;
}
