package com.exemple.api.rest.apirest.repository;

import com.exemple.api.rest.apirest.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
