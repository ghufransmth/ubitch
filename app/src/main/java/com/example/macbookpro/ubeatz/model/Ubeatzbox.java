package com.example.macbookpro.ubeatz.model;

public class Ubeatzbox {
    private static final String TAG = "Ubeatzbox";

    private String ubeatzboxName;
    private int ubeatzboxImg;

    public Ubeatzbox(int ubeatzboxImg, String ubeatzboxName) {
        super();
        this.setUbeatzboxImg(ubeatzboxImg);
        this.setUbeatzboxName(ubeatzboxName);
    }

    public String getUbeatzboxName() {
        return ubeatzboxName;
    }

    public void setUbeatzboxName(String ubeatzboxName) {
        this.ubeatzboxName = ubeatzboxName;
    }

    public int getImg() {
        return ubeatzboxImg;
    }

    public void setUbeatzboxImg(int ubeatzboxImg) {
        this.ubeatzboxImg = ubeatzboxImg;
    }
}
