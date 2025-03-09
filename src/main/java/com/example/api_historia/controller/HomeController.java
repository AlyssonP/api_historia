package com.example.api_historia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping
    public ResponseEntity<Map<String, String>> index() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "API de histórias");
        response.put("versão", "1.0.0");
        return ResponseEntity.ok(response);
    }
}
