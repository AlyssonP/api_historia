package com.example.api_historia.controller;

import com.example.api_historia.domain.conteudo.ConteudoDTO;
import com.example.api_historia.services.ConteudoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conteudos")
@RequiredArgsConstructor
public class ConteudoController {

    private final ConteudoService service;

    @PostMapping
    public ResponseEntity<ConteudoDTO> create(@RequestBody ConteudoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping("/historia/{idHistoria}")
    public ResponseEntity<List<ConteudoDTO>> getByHistoria(@PathVariable Long idHistoria) {
        return ResponseEntity.ok(service.getByHistoria(idHistoria));
    }

    @GetMapping("/historia/{idHistoria}/secao/{secao}")
    public ResponseEntity<ConteudoDTO> getBySecao(
            @PathVariable Long idHistoria,
            @PathVariable Integer secao
    ) {
        return ResponseEntity.ok(service.getBySecao(idHistoria, secao));
    }
}
