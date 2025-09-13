package com.exemple.api.rest.apirest.entity;
import java.util.List;
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
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String nome;
    @OneToMany(mappedBy = "artista")
    private List<Album> albuns;

    @OneToMany(mappedBy = "artista")
    private List<Musica> musicas;

    @Override
    public String toString() {
        return "artista{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
