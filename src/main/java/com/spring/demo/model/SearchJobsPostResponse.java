package com.spring.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
public class SearchJobsPostResponse {
    @Schema(example = "Java Developer", type = "String", description = "Only Send Title for Search Title ")
    private String title;
    @Schema(example = "1500", type = "double")
    private double firstPrice;
    @Schema(example = "2500", type = "double")
    private double lastPrice;
    @Schema(example = "2021-04-10T09:14:14.110Z")
    private Date date;
    @Schema(example = "4", type = "Integer", description = "Only Send category id for Search cateId ")
    private int cateId;
}
