package com.example.macbookpro.ubeatz.model;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Findbox {
    private String id;
    private String nama;
    private String desc;

    public Findbox() {

    }

    public Findbox(String nama, String desc) {
        this.nama = nama;
        this.desc = desc;
    }

    public String getNama() {
        return nama;
    }

    public String getDesc() {
        return desc;
    }

}
