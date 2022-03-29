package com.spring.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobApplicationResponse {
    @Schema(type = "Integer", example = "4", description = "Post Not Send Id")
    private int id;
    @Schema(type = "double", example = "1500")
    private double myBid;
    @Schema(type = "String", example = "Hello")
    private String description;
    @Schema(type = "Integer", example = "44")
    private int jobId;
    @Schema(type = "String", description = "File Pdf")
    private MultipartFile photo;
}
