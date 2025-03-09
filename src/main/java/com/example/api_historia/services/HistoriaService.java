package com.example.api_historia.services;

import com.example.api_historia.domain.historia.HistoriaDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.api_historia.domain.historia.Historia;
import com.example.api_historia.repositories.HistoriaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoriaService {

    @Autowired
    private HistoriaRepository repository;

    @Transactional
    public HistoriaDTO create(HistoriaDTO dto) {
        Historia historia = new Historia();
        historia.setTitulo(dto.getTitulo());
        return toDTO(repository.save(historia));
    }

    public List<HistoriaDTO> getAll() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    private HistoriaDTO toDTO(Historia entity) {
        return new HistoriaDTO(entity.getId(), entity.getTitulo());
    }
}
