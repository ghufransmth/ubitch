package com.example.macbookpro.ubeatz.response;

import com.example.macbookpro.ubeatz.model.Comment;
import com.example.macbookpro.ubeatz.model.Following;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class responsecomment {

    @SerializedName("success")
    public int success;

    @SerializedName("result")
    public ArrayList<Comment> datacomment = new ArrayList<>();

    public ArrayList<Comment> getComments() {
        return datacomment;
    }

}
