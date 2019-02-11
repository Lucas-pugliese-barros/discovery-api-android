package com.barros.pugliese.discoveryapiandroid.Model;


import com.google.gson.annotations.SerializedName;

public class Icons {

    @SerializedName("x16")
    private String x16;

    @SerializedName("x32")
    private String x32;

    public Icons() {
    }

    public String getX16() {
        return x16;
    }

    public void setX16(String x16) {
        this.x16 = x16;
    }

    public String getX32() {
        return x32;
    }

    public void setX32(String x32) {
        this.x32 = x32;
    }
}