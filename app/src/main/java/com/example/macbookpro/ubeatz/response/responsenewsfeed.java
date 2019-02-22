package com.example.macbookpro.ubeatz.response;

import com.example.macbookpro.ubeatz.model.News;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class responsenewsfeed {
    @SerializedName("success")
    public int success;

    @SerializedName("result")
    public ArrayList<News> datanews = new ArrayList<>();

    public ArrayList<News> getNews() {
        return datanews;
    }
}
