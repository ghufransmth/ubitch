package com.example.macbookpro.ubeatz.model;

public class Scores {
    private static final String TAG = "Scores";

    private String scoresName;
    private int scoresImg;

    public Scores(int scoresImg, String scoresName) {
        super();
        this.setScoresImg(scoresImg);
        this.setScoresName(scoresName);
    }

    public String getScoresName() {
        return scoresName;
    }

    public void setScoresName(String scoresName) {
        this.scoresName = scoresName;
    }

    public int getImg() {
        return scoresImg;
    }

    public void setScoresImg(int scoresImg) {
        this.scoresImg = scoresImg;
    }
}
