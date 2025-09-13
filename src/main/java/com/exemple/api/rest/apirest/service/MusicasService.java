package com.exemple.api.rest.apirest.service;
import com.exemple.api.rest.apirest.entity.Musica;
import com.exemple.api.rest.apirest.repository.MusicasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicasService {

    @Autowired
    private MusicasRepository musicasRepository;

    public Musica save(Musica musica){
        return musicasRepository.save(musica);
    }

    public List<Musica> findAll(){
        return musicasRepository.findAll();
    }

    public Musica findById(Long id){
        return musicasRepository.findById(id).orElse(null);
    }

    public void delete(Long id){
        if (musicasRepository.existsById(id)) {
            musicasRepository.deleteById(id);
        }
    }
}
