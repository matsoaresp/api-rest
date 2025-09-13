package com.exemple.api.rest.apirest.controller;

import com.exemple.api.rest.apirest.entity.Album;
import com.exemple.api.rest.apirest.entity.Artista;
import com.exemple.api.rest.apirest.entity.Musica;
import com.exemple.api.rest.apirest.service.AlbumService;
import com.exemple.api.rest.apirest.service.ArtistaService;
import com.exemple.api.rest.apirest.service.MusicasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicasController {

    @Autowired
    private MusicasService musicasService;

    @Autowired
    private ArtistaService artistaService;

    @Autowired
    private AlbumService albumService;

    // Criar música
    @PostMapping("/criarMusica")
    public ResponseEntity<?> createMusica(@RequestBody Musica musica) {

        if (musica.getArtista() == null || musica.getArtista().getId() == null) {
            return ResponseEntity.badRequest().body("O artista deve ser informado");
        }
        Artista artista = artistaService.findById(musica.getArtista().getId());
        if (artista == null) {
            return ResponseEntity.badRequest().body("Artista não encontrado");
        }
        musica.setArtista(artista);


        if (musica.getAlbum() != null && musica.getAlbum().getId() != null) {
            Album album = albumService.findById(musica.getAlbum().getId());
            if (album == null) {
                return ResponseEntity.badRequest().body("Álbum não encontrado");
            }
            musica.setAlbum(album);
        }

        Musica createdMusica = musicasService.save(musica);
        return ResponseEntity.ok(createdMusica);
    }

    // Listar todas as músicas
    @GetMapping
    public ResponseEntity<List<Musica>> getAllMusicas() {
        List<Musica> musicas = musicasService.findAll();
        return ResponseEntity.ok(musicas);
    }

    // Buscar música por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getMusicaById(@PathVariable long id) {
        Musica musica = musicasService.findById(id);
        if (musica == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(musica);
    }

    // Deletar música por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMusicaById(@PathVariable long id) {
        Musica musica = musicasService.findById(id);
        if (musica == null) {
            return ResponseEntity.notFound().build();
        }
        musicasService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
