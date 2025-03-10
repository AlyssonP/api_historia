package com.example.api_historia.domain.historia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoriaDTO {
    private Long id;
    private String titulo;

    public HistoriaDTO(String titulo) {
        this.titulo = titulo;
    }
}
