package com.exemple.api.rest.apirest.entity;

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
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String titulo;
    int anoLancamento;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    @Override
    public String toString() {
        return "album{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", anoLancamento=" + anoLancamento +
                '}';
    }
}
