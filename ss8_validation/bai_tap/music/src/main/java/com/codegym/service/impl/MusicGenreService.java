package com.codegym.service.impl;

import com.codegym.model.MusicGenre;
import com.codegym.repository.IMusicGenreRepository;
import com.codegym.service.IMusicGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicGenreService implements IMusicGenreService {
    @Autowired
    private IMusicGenreRepository iMusicGenreRepository;

    @Override
    public List<MusicGenre> findAll() {
        return iMusicGenreRepository.findAll();
    }
}
