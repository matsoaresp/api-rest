package com.exemple.api.rest.apirest.controller;

import com.exemple.api.rest.apirest.entity.Album;
import com.exemple.api.rest.apirest.entity.Artista;
import com.exemple.api.rest.apirest.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaService artistaService;

    @PostMapping("/criarArtista")
    public ResponseEntity<Artista> createArtista(@RequestBody Artista artista) {
        Artista createdArtista = artistaService.save(artista);
        return ResponseEntity.ok(createdArtista);
    }

    @GetMapping
    public ResponseEntity<List<Artista>> getAllArtistas() {
        List<Artista> artistas = artistaService.findAll();
        return ResponseEntity.ok(artistas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artista> getArtistaById(@PathVariable long id) {
        Artista artista = artistaService.findById(id);
        if (artista == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(artista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtistaById(@PathVariable long id) {
        artistaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
