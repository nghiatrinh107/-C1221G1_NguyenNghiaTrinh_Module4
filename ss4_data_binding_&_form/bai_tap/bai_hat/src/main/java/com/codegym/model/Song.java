package com.codegym.model;

public class Song {
    private String name;
    private String singer;
    private String musicGenre;
    private String link;

    public Song() {
    }

    public Song(String name, String singer, String musicGenre, String link) {
        this.name = name;
        this.singer = singer;
        this.musicGenre = musicGenre;
        this.link = link;
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
