package com.example.macbookpro.ubeatz.response;

import com.example.macbookpro.ubeatz.model.Following;
import com.example.macbookpro.ubeatz.model.News;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class responsefollowing {

    @SerializedName("success")
    public int success;

    @SerializedName("result")
    public ArrayList<Following> datafollow = new ArrayList<>();

    public ArrayList<Following> getFollow() {
        return datafollow;
    }

}
