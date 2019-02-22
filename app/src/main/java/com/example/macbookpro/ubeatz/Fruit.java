package com.example.macbookpro.ubeatz;

public class Fruit {

    private static final String TAG = "Fruit";

    private int fruitImg;
    private String fruitName;
    private String calories;

    public Fruit(int fruitImg, String fruitName) {
        super();
        this.setFruitImg(fruitImg);
        this.setFruitName(fruitName);
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getFruitImg() {
        return fruitImg;
    }

    public void setFruitImg(int fruitImg) {
        this.fruitImg = fruitImg;
    }
}
