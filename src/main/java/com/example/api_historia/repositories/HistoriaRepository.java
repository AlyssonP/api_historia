package com.example.api_historia.repositories;

import com.example.api_historia.domain.historia.Historia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoriaRepository extends JpaRepository<Historia, Long> {
}
