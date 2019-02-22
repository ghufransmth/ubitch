package com.example.macbookpro.ubeatz.response;

import com.example.macbookpro.ubeatz.model.Followers;
import com.example.macbookpro.ubeatz.model.Friends;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class responsefriends {
    @SerializedName("success")
    public int success;

    @SerializedName("result")
    public ArrayList<Friends> datafriends = new ArrayList<>();

    public ArrayList<Friends> getFriends() {
        return datafriends;
    }
}
