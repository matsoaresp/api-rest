package com.exemple.api.rest.apirest.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference("artista-album")
    private List<Album> albuns;

    @OneToMany(mappedBy = "artista")
    @JsonManagedReference("artista-musica")
    private List<Musica> musicas;

    @Override
    public String toString() {
        return "artista{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
