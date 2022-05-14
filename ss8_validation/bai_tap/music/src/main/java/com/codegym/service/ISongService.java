package com.codegym.service;

import com.codegym.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService {
    Page<Song> findAllAndSearch(String searchKeyWord, Pageable pageable);

    void save(Song song);
}
