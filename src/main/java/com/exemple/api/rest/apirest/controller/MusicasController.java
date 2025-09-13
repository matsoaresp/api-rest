package com.exemple.api.rest.apirest.controller;


import com.exemple.api.rest.apirest.entity.Artista;
import com.exemple.api.rest.apirest.entity.Musica;
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

    @PostMapping("/criarMusica")
    public ResponseEntity<Musica> createMusica(@RequestBody Musica musica) {
        Musica createdMusica = musicasService.save(musica);
        return ResponseEntity.ok(createdMusica);
    }

    @GetMapping
    public ResponseEntity<List<Musica>> getAllMusicas() {
        List<Musica> musicas = musicasService.findAll();
        return ResponseEntity.ok(musicas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musica> getMusicaById(@PathVariable long id) {
        Musica musica = musicasService.findById(id);
        if (musica == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(musica);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMusicaById(@PathVariable long id) {
        musicasService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
