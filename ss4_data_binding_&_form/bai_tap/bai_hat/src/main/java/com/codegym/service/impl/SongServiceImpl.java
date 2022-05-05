package com.codegym.service.impl;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService<Song> {
    @Autowired
    private ISongRepository iSongRepository;
    @Override
    public List<Song> findAll() {
        return this.iSongRepository.findAll();
    }

    @Override
    public void save(Song song) {
        this.iSongRepository.save(song);
    }
}
