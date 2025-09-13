package com.exemple.api.rest.apirest.repository;
import com.exemple.api.rest.apirest.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicasRepository extends JpaRepository<Musica, Long> {
}
