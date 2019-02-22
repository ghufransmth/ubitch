package com.example.macbookpro.ubeatz.model;

public class Song {
    private static final String TAG = "Song";

    private String songName;
    private int songImg;

    public Song(int songImg, String songName) {
        super();
        this.setSongImg(songImg);
        this.setSongName(songName);
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getImg() {
        return songImg;
    }

    public void setSongImg(int songImg) {
        this.songImg = songImg;
    }
}
