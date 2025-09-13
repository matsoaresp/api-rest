package com.exemple.api.rest.apirest.service;

import com.exemple.api.rest.apirest.entity.Album;
import com.exemple.api.rest.apirest.repository.AlbumRepository;
import com.exemple.api.rest.apirest.repository.MusicasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Album save(Album album) {
        return albumRepository.save(album);
    }

    public List<Album> findAll() {
        return albumRepository.findAll();
    }
    public Album findById(Long id) {
        return albumRepository.findById(id).orElse(null);
    }
    public void delete(Long id) {
        if (albumRepository.existsById(id)) {
            albumRepository.deleteById(id);
        }
    }


}
