package com.example.api_historia.domain.historia;

import com.example.api_historia.domain.conteudo.Conteudo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Historia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @OneToMany(mappedBy = "historia", cascade = CascadeType.ALL)
    private List<Conteudo> conteudos = new ArrayList<>();
}