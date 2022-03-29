package com.spring.demo.service;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IFileUploadService {
    ResponseEntity<ByteArrayResource> getImage(String photo);
    String storeFile(MultipartFile photo);
}
