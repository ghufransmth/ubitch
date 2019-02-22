package com.example.macbookpro.ubeatz.response;

import com.example.macbookpro.ubeatz.model.Followers;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class responsefollowers {
    @SerializedName("success")
    public int success;

    @SerializedName("result")
    public ArrayList<Followers> datafollower = new ArrayList<>();

    public ArrayList<Followers> getFollow() {
        return datafollower;
    }
}
