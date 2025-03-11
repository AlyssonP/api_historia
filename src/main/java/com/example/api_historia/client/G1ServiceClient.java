package com.example.api_historia.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "g1-service", url = "${g1.service.url}")
public interface G1ServiceClient {
    @GetMapping("/api/historia/{part}")
    Map<String, String> getParteHistoria(@PathVariable("part") int part);
}
