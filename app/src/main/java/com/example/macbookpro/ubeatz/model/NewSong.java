package com.example.macbookpro.ubeatz.model;

public class NewSong {

    private static final String TAG = "NewSong";

    private int idlagu;
    private String judul;
    private String artis;

    public NewSong(int idlagu, String judul, String artis) {
        this.idlagu = idlagu;
        this.judul  = judul;
        this.artis  = artis;
    }

    public int getIdLagu() {
        return idlagu;
    }

    public void setIdLagu(int idlagu) {
        this.idlagu = idlagu;
    }

    public String getJudulName() {
        return judul;
    }

    public void setJudulName(String judul) {
        this.judul = judul;
    }

    public String getArtis() {
        return artis;
    }

    public void setArtis(String artis) {
        this.artis = artis;
    }

}
