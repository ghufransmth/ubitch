package com.example.macbookpro.ubeatz.util;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ghufran on 12/9/2017.
 */

public class ServerResponse {
    @SerializedName("success")
    public int success;

    private String message;
    private Boolean error;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }
}
