package com.codegym.repository;

import com.codegym.model.MusicGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicGenreRepository extends JpaRepository<MusicGenre,Integer> {
}
