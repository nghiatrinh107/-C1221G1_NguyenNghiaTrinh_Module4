package com.codegym.service;

import com.codegym.model.MusicGenre;

import java.util.List;

public interface IMusicGenreService {
    List<MusicGenre> findAll();
}
