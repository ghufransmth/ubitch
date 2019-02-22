package com.example.macbookpro.ubeatz.util;

import android.os.Parcel;
import android.os.Parcelable;

public class SpaceFoto implements Parcelable {
    private String mUrl;
    private String mTitle;

    public SpaceFoto(String url, String title) {
        mUrl = url;
        mTitle = title;
    }

    protected SpaceFoto(Parcel in) {
        mUrl = in.readString();
        mTitle = in.readString();
    }

    public static final Creator<SpaceFoto> CREATOR = new Creator<SpaceFoto>() {
        @Override
        public SpaceFoto createFromParcel(Parcel in) {
            return new SpaceFoto(in);
        }

        @Override
        public SpaceFoto[] newArray(int size) {
            return new SpaceFoto[size];
        }
    };

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public static SpaceFoto[] getSpacePhotos() {

        return new SpaceFoto[]{
                new SpaceFoto("http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages1.jpg", "Galaxy"),
                new SpaceFoto("http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages2.jpg", "Space Shuttle"),
                new SpaceFoto("http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages3.jpg", "Galaxy Orion"),
                new SpaceFoto("http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages4.jpg", "Earth"),
                new SpaceFoto("http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages5.jpg", "Astronaut"),
                new SpaceFoto("http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages6.jpg", "Satellite"),
                new SpaceFoto("http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages7.jpg", "Space"),
                new SpaceFoto("http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages8.jpg", "Earth"),
                new SpaceFoto("http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages1.jpg", "Astronaut"),
                new SpaceFoto("http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages2.jpg", "Satellite"),
                new SpaceFoto("http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages3.jpg", "Astronaut"),
                new SpaceFoto("http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages4.jpg", "Earth"),
                new SpaceFoto("http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages5.jpg", "Galaxy"),
                new SpaceFoto("http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages6.jpg", "Satellite"),
                new SpaceFoto("http://ubeatz.rapiertechnology.co.id/assets/uploads/images/gettyimages7.jpg", "Space"),
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mUrl);
        parcel.writeString(mTitle);
    }
}
