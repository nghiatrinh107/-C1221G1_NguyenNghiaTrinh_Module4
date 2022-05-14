package com.codegym.repository;

import com.codegym.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song,Integer> {
    Page<Song>findAllByNameContaining(String searchKeyWord, Pageable pageable);
}
