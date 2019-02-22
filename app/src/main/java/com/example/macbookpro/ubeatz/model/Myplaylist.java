package com.example.macbookpro.ubeatz.model;

public class Myplaylist {
    private static final String TAG = "Myplaylist";

    private String myplaylistName;
    private String myplaylistName2;
    private int myplaylistImg;

    public Myplaylist(int myplaylistImg, String myplaylistName, String myplaylistName2) {
        super();
        this.setMyplaylistImg(myplaylistImg);
        this.setMyplaylistName(myplaylistName);
        this.setMyplaylistName2(myplaylistName2);
    }

    public String getMyplaylistName() {
        return myplaylistName;
    }

    public void setMyplaylistName(String myplaylistName) {
        this.myplaylistName = myplaylistName;
    }

    public String getMyplaylistName2() {
        return myplaylistName2;
    }

    public void setMyplaylistName2(String myplaylistName2) {
        this.myplaylistName2 = myplaylistName2;
    }

    public int getImg() {
        return myplaylistImg;
    }

    public void setMyplaylistImg(int myplaylistImg) {
        this.myplaylistImg = myplaylistImg;
    }
}
