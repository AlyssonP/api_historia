package com.example.api_historia.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "g2-service", url = "${g2.service.url}")
public interface G2ServiceClient {
    @GetMapping("/api/historia/{part}")
    Map<String, String> getParteHistoria(@PathVariable("part") int part);
}
