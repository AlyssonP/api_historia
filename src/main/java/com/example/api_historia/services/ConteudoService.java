package com.example.api_historia.services;

import com.example.api_historia.domain.conteudo.Conteudo;
import com.example.api_historia.domain.conteudo.ConteudoDTO;
import com.example.api_historia.domain.historia.Historia;
import com.example.api_historia.repositories.ConteudoRepository;
import com.example.api_historia.repositories.HistoriaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConteudoService {

    @Autowired
    private ConteudoRepository repository;
    @Autowired
    private HistoriaRepository historiaRepository;

    @Transactional
    public ConteudoDTO create(ConteudoDTO dto) {
        Historia historia = historiaRepository.findById(dto.getIdHistoria())
                .orElseThrow(() -> new RuntimeException("História não encontrada"));

        Conteudo conteudo = new Conteudo();
        conteudo.setSecao(dto.getSecao());
        conteudo.setTexto(dto.getTexto());
        conteudo.setHistoria(historia);

        return toDTO(repository.save(conteudo));
    }

    public List<ConteudoDTO> getByHistoria(Long historiaId) {
        return repository.findByHistoriaId(historiaId).stream()
                .map(this::toDTO)
                .toList();
    }

    public ConteudoDTO getBySecao(Long historiaId, Integer secao) {
        return repository.findByHistoriaIdAndSecao(historiaId, secao)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Seção não encontrada"));
    }

    private ConteudoDTO toDTO(Conteudo entity) {
        return new ConteudoDTO(
                entity.getId(),
                entity.getSecao(),
                entity.getTexto(),
                entity.getHistoria().getId()
        );
    }
}
