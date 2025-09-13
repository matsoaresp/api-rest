package com.exemple.api.rest.apirest.entity;

import com.exemple.api.rest.apirest.entity.Artista;
import jakarta.persistence.*;


@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private Integer anoLancamento;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Integer getAnoLancamento() { return anoLancamento; }
    public void setAnoLancamento(Integer anoLancamento) { this.anoLancamento = anoLancamento; }

    public Artista getArtista() { return artista; }
    public void setArtista(Artista artista) { this.artista = artista; }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", anoLancamento=" + anoLancamento +
                ", artista=" + (artista != null ? artista.getNome() : null) +
                '}';
    }
}
