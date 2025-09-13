package com.exemple.api.rest.apirest.entity;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String nome;
    @OneToMany(mappedBy = "artista")
    private List<Album> albuns;

    @OneToMany(mappedBy = "artista")
    private List<Musica> musicas;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "artista{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
