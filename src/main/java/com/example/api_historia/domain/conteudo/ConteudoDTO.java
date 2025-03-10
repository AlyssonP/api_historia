package com.example.api_historia.domain.conteudo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConteudoDTO {
    private Long id;
    private Integer secao;
    private String texto;
    private Long idHistoria;

    public ConteudoDTO(Integer secao, String texto, Long idHistoria) {
        this.secao = secao;
        this.texto = texto;
        this.idHistoria = idHistoria;
    }
}
