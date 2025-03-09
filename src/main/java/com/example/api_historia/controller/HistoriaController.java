package com.example.api_historia.controller;

import com.example.api_historia.domain.historia.Historia;
import com.example.api_historia.domain.historia.HistoriaDTO;
import com.example.api_historia.services.HistoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historias")
@RequiredArgsConstructor
public class HistoriaController {

    private final HistoriaService service;

    @PostMapping
    public ResponseEntity<HistoriaDTO> create(@RequestBody HistoriaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<HistoriaDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
