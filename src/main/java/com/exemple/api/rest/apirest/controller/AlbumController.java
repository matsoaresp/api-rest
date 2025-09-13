package com.exemple.api.rest.apirest.controller;

import com.exemple.api.rest.apirest.entity.Album;
import com.exemple.api.rest.apirest.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albuns")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @PostMapping("/criarAlbum")
    public ResponseEntity<Album> createAlbum(@RequestBody Album album) {
        Album createdAlbum = albumService.save(album);
        return ResponseEntity.ok(createdAlbum);
    }

    @GetMapping
    public ResponseEntity<List<Album>> getAllAlbums() {
        List<Album> albums = albumService.findAll();
        return ResponseEntity.ok(albums);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable long id) {
        Album album = albumService.findById(id);
        return ResponseEntity.ok(album);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlbumById(@PathVariable long id) {
        albumService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
