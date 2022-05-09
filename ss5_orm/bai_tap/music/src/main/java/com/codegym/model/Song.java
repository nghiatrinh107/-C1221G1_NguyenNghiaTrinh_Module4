package com.codegym.model;


import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String singer;
    private String musicGenre;
    private String link;

    public Song() {
    }

    public Song(Integer id, String name, String singer, String musicGenre, String link) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.musicGenre = musicGenre;
        this.link = link;
    }

    public Song(String name, String singer, String musicGenre, String link) {
        this.name = name;
        this.singer = singer;
        this.musicGenre = musicGenre;
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
