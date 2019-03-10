package com.barros.pugliese.discoveryapiandroid.dto;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DiscoveryApisDTO {

    @SerializedName("kind")
    String kind;

    @SerializedName("discoveryVersion")
    String discoveryVersion;

    @SerializedName("items")
    List<ApiDTO> apiDTOS;

    public DiscoveryApisDTO() {
    }

    public DiscoveryApisDTO(List<ApiDTO> apiDTOS) {
        this.apiDTOS = apiDTOS;
    }

    public List<ApiDTO> getApiDTOS() {
        return apiDTOS;
    }

    public void setApiDTOS(List<ApiDTO> apiDTOS) {
        this.apiDTOS = apiDTOS;
    }

    @Override
    public String toString() {
        return "DiscoveryApis{" +
                "kind='" + kind + '\'' +
                ", discoveryVersion='" + discoveryVersion + '\'' +
                ", apis=" + apiDTOS +
                '}';
    }

    public static DiscoveryApisDTO fromJson(String string) {
        Gson gson = new Gson();
        return gson.fromJson(string, DiscoveryApisDTO.class);
    }
}
