package com.example.api_historia.controller;

import com.example.api_historia.client.G1ServiceClient;
import com.example.api_historia.client.G2ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/historia")
@CrossOrigin(origins = "*")
public class HistoriasController {

    @Autowired
    private G1ServiceClient g1Service;
    @Autowired
    private G2ServiceClient g2Service;

    @GetMapping("/1")
    public ResponseEntity<Map<String, String>> parteHistoria01() {
        return ResponseEntity.ok(Collections.singletonMap("historia", "como ele é um gato, não teve nada."));
    }

    @GetMapping("/2")
    public ResponseEntity<Map<String, String>> parteHistoria02() {
        return ResponseEntity.ok(Collections.singletonMap("historia", "conheceram o professor de Sistemas Distribuídos"));
    }

    @GetMapping("/3")
    public ResponseEntity<Map<String, String>> parteHistoria03() {
        return ResponseEntity.ok(Collections.singletonMap("historia", "O estagiário chegou às 08 horas da manhã"));
    }


    @GetMapping("/1/completa")
    public ResponseEntity<String> historia01() {
        String parteG1 = g1Service.getParteHistoria(1).get("historia");
        String parteG2 = g2Service.getParteHistoria(1).get("historia");
        String parteG3 = "como ele é um gato, não teve nada.";

        String historiaCompleta = String.join(" ", parteG1, parteG2, parteG3);
        return ResponseEntity.ok(Collections.singletonMap("historia", historiaCompleta).toString());
    }

    @GetMapping("/2/completa")
    public ResponseEntity<String> historia02() {
        String parteG2 = g2Service.getParteHistoria(2).get("historia");
        String parteG3 = "conheceram o professor de Sistemas Distribuídos";
        String parteG1 = g1Service.getParteHistoria(2).get("historia");

        String historiaCompleta = String.join(" ", parteG2, parteG3, parteG1);
        return ResponseEntity.ok(Collections.singletonMap("historia", historiaCompleta).toString());
    }

    @GetMapping("/3/completa")
    public ResponseEntity<String> historia03() {
        String parteG3 = "O estagiário chegou às 08 horas da manhã";
        String parteG1 = g1Service.getParteHistoria(3).get("historia");
        String parteG2 = g2Service.getParteHistoria(3).get("historia");

        String historiaCompleta = String.join(" ", parteG3, parteG1, parteG2);
        return ResponseEntity.ok(Collections.singletonMap("historia", historiaCompleta).toString());
    }
}