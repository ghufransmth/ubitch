package com.example.macbookpro.ubeatz.model;

import android.graphics.Bitmap;

public class Item {

    private static final String TAG = "Item";

    private String title;
    private Bitmap image;

    public Item(String title, Bitmap image) {
        super();
        this.setTitle(title);
        this.setImage(image);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
