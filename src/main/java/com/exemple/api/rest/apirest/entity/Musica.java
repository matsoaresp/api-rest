package com.exemple.api.rest.apirest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    String nome;
    String genero;
    int anoLancamento;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    @JsonBackReference("artista-musica")
    private Artista artista;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @Override
    public String toString() {
        return "musica{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", anoLancamento=" + anoLancamento +
                '}';
    }
}
