package com.example.macbookpro.ubeatz.model;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Newsfeed {
    private static final String TAG = "Newsfeed";

    private String nama;
    private String deskripsi;

    public Newsfeed() {

    }

    public Newsfeed(String nama, String deskripsi) {
        this.nama = nama;
        this.deskripsi = deskripsi;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
}
