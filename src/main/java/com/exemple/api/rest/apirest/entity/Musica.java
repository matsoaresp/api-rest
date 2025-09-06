package com.exemple.api.rest.apirest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class musicas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String artista;
    String nome;
    String genero;
    int anoLancamento;

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }




    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
