package com.exemple.api.rest.apirest.controller;

import com.exemple.api.rest.apirest.entity.Album;
import com.exemple.api.rest.apirest.entity.Artista;
import com.exemple.api.rest.apirest.service.AlbumService;
import com.exemple.api.rest.apirest.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albuns")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ArtistaService artistaService;

    // Criar um álbum
    @PostMapping("/criarAlbum")
    public ResponseEntity<?> createAlbum(@RequestBody Album album) {
        if (album.getArtista() == null || album.getArtista().getId() == null) {
            return ResponseEntity.badRequest().body("Artista é obrigatório para criar um álbum.");
        }

        Artista artista = artistaService.findById(album.getArtista().getId());
        if (artista == null) {
            return ResponseEntity.badRequest().body("Artista não encontrado.");
        }

        album.setArtista(artista);
        Album createdAlbum = albumService.save(album);
        return ResponseEntity.ok(createdAlbum);
    }

    // Listar todos os álbuns
    @GetMapping
    public ResponseEntity<List<Album>> getAllAlbums() {
        List<Album> albums = albumService.findAll();
        return ResponseEntity.ok(albums);
    }

    // Buscar álbum por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getAlbumById(@PathVariable long id) {
        Album album = albumService.findById(id);
        if (album == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(album);
    }

    // Deletar álbum por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAlbumById(@PathVariable long id) {
        Album album = albumService.findById(id);
        if (album == null) {
            return ResponseEntity.notFound().build();
        }
        albumService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Atualizar álbum existente
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAlbum(@PathVariable long id, @RequestBody Album album) {
        Album existingAlbum = albumService.findById(id);
        if (existingAlbum == null) {
            return ResponseEntity.notFound().build();
        }

        if (album.getArtista() != null && album.getArtista().getId() != null) {
            Artista artista = artistaService.findById(album.getArtista().getId());
            if (artista == null) {
                return ResponseEntity.badRequest().body("Artista não encontrado.");
            }
            existingAlbum.setArtista(artista);
        }

        if (album.getTitulo() != null) {
            existingAlbum.setTitulo(album.getTitulo());
        }
        if (album.getAnoLancamento() != 0) {
            existingAlbum.setAnoLancamento(album.getAnoLancamento());
        }

        Album updatedAlbum = albumService.save(existingAlbum);
        return ResponseEntity.ok(updatedAlbum);
    }
}
