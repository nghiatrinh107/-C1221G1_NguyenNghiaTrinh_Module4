package com.codegym.repository.impl;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongRepository implements ISongRepository {
    private static List<Song> songList = new ArrayList<>();
    static {
        songList.add(new Song("bai 1","Nguyen Van A","Pop","link1"));
        songList.add(new Song("bai 2","Nguyen Van B","Rap","link2"));
        songList.add(new Song("bai 3","Nguyen Van C","Pop","link3"));
        songList.add(new Song("bai 4","Nguyen Van D","R&B","link4"));
    }

    @Override
    public List<Song> findAll() {
        return songList;
    }

    @Override
    public void save(Song song) {
        songList.add(song);
    }
}
