package com.example.api_historia.repositories;

import com.example.api_historia.domain.conteudo.Conteudo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConteudoRepository extends JpaRepository<Conteudo, Long> {
    List<Conteudo> findByHistoriaId(Long historiaId);
    Optional<Conteudo> findByHistoriaIdAndSecao(Long historiaId, Integer secao);
}
