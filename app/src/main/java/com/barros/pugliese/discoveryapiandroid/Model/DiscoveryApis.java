package com.barros.pugliese.discoveryapiandroid.Model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DiscoveryApis {

    @SerializedName("kind")
    String kind;

    @SerializedName("discoveryVersion")
    String discoveryVersion;

    @SerializedName("items")
    List<Api> apis;

    public DiscoveryApis() {
    }

    public DiscoveryApis(List<Api> apis) {
        this.apis = apis;
    }

    public List<Api> getApis() {
        return apis;
    }

    public void setApis(List<Api> apis) {
        this.apis = apis;
    }

    @Override
    public String toString() {
        return "DiscoveryApis{" +
                "kind='" + kind + '\'' +
                ", discoveryVersion='" + discoveryVersion + '\'' +
                ", apis=" + apis +
                '}';
    }

    public static DiscoveryApis fromJson(String string) {
        Gson gson = new Gson();
        return gson.fromJson(string, DiscoveryApis.class);
    }
}
