package com.spring.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController(value = "/clients")
@Tag(name = "Clients Api")
public class ClientsRestController {
    @GetMapping
    public List<String> getClients() {
        return Arrays.asList("First Client", "Second Client");
    }

}