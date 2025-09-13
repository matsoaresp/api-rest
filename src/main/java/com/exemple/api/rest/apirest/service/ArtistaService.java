package com.exemple.api.rest.apirest.service;

import com.exemple.api.rest.apirest.entity.Artista;
import com.exemple.api.rest.apirest.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaService {


    @Autowired
    private ArtistaRepository artistaRepository;

    public Artista save(Artista artista){
        return artistaRepository.save(artista);
    }

    public List<Artista> findAll(){
        return artistaRepository.findAll();
    }

    public Artista findById(Long id){
        return artistaRepository.findById(id).orElse(null);
    }
    public void delete(Long id){
        artistaRepository.deleteById(id);
    }
}
