package com.spring.demo.service.impl;

import com.spring.demo.service.IFileUploadService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

@Service
public class FileUploadServiceImpl implements IFileUploadService {
    public ResponseEntity<ByteArrayResource> getImage(String photo) {
        if (!photo.equals("") || photo != null) {
            try {
                Path fileName = Paths.get("uploads", photo);
                byte[] buffer = Files.readAllBytes(fileName);
                ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
                return ResponseEntity.ok().contentLength(buffer.length)
                        .contentType(MediaType.parseMediaType("image/jpeg"))//infor.getFileType();
                        .body(byteArrayResource);
            } catch (Exception e) {
                System.err.println("Could not store file " + photo + ". Please try again!");
            }
        }
        return ResponseEntity.badRequest().build();
    }

    public String storeFile(MultipartFile photo) {
        Path path = Paths.get("uploads/");
        Date date = new Date();
        String name = String.valueOf(date.getTime());
        String fileName = name + "_" + photo.getOriginalFilename();
        try {
            InputStream inputStream = photo.getInputStream();
            Files.copy(inputStream, path.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.err.println("Could not store file " + fileName + ". Please try again!");
        }
        return fileName;
    }
}
