package com.exemple.api.rest.apirest.controller;

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

    // Criar artista
    @PostMapping("/criarArtista")
    public ResponseEntity<Artista> createArtista(@RequestBody Artista artista) {
        Artista createdArtista = artistaService.save(artista);
        return ResponseEntity.ok(createdArtista);
    }

    // Listar todos os artistas
    @GetMapping
    public ResponseEntity<List<Artista>> getAllArtistas() {
        List<Artista> artistas = artistaService.findAll();
        return ResponseEntity.ok(artistas);
    }

    // Buscar artista por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getArtistaById(@PathVariable long id) {
        Artista artista = artistaService.findById(id);
        if (artista == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(artista);
    }

    // Deletar artista por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArtistaById(@PathVariable long id) {
        Artista artista = artistaService.findById(id);
        if (artista == null) {
            return ResponseEntity.notFound().build();
        }
        artistaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Atualizar artista
    @PutMapping("/{id}")
    public ResponseEntity<?> updateArtista(@PathVariable long id, @RequestBody Artista artista) {
        Artista existingArtista = artistaService.findById(id);
        if (existingArtista == null) {
            return ResponseEntity.notFound().build();
        }

        if (artista.getNome() != null) {
            existingArtista.setNome(artista.getNome());
        }

        Artista updatedArtista = artistaService.save(existingArtista);
        return ResponseEntity.ok(updatedArtista);
    }
}
