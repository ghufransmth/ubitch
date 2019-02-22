package com.example.macbookpro.ubeatz.model;

public class Location {
    private static final String TAG = "Location";

    private String locationName;
    private int locationImg;

    public Location(int locationImg, String locationName) {
        super();
        this.setLocationImg(locationImg);
        this.setLocationName(locationName);
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getImg() {
        return locationImg;
    }

    public void setLocationImg(int locationImg) {
        this.locationImg = locationImg;
    }
}
