package com.barros.pugliese.discoveryapiandroid.Model;

import com.google.gson.annotations.SerializedName;

public class Api {

    @SerializedName("id")
    private String id;

    @SerializedName("kind")
    private String kind;

    @SerializedName("name")
    private String name;

    @SerializedName("version")
    private String version;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("discoveryRestUrl")
    private String discoveryRestUrl;

    @SerializedName("icons")
    private Icons icons;

    @SerializedName("documentationLink")
    private String documentationLink;

    @SerializedName("preferred")
    private Boolean preferred;

    private boolean isFavorited = false;

    public Api() {
    }

    public Api(String kind, String name, String version, String title, String description,
               String discoveryRestUrl, Icons icons, String documentationLink, Boolean preferred,
               boolean isFavorited) {

        this.kind = kind;
        this.name = name;
        this.version = version;
        this.title = title;
        this.description = description;
        this.discoveryRestUrl = discoveryRestUrl;
        this.icons = icons;
        this.documentationLink = documentationLink;
        this.preferred = preferred;
        this.isFavorited = isFavorited;
    }

    public Api(String kind, String name, String version, String title, String description,
               String discoveryRestUrl, String documentationLink, boolean isFavorited) {

        this.kind = kind;
        this.name = name;
        this.version = version;
        this.title = title;
        this.description = description;
        this.discoveryRestUrl = discoveryRestUrl;
        this.documentationLink = documentationLink;
        this.isFavorited = isFavorited;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscoveryRestUrl() {
        return discoveryRestUrl;
    }

    public void setDiscoveryRestUrl(String discoveryRestUrl) {
        this.discoveryRestUrl = discoveryRestUrl;
    }

    public Icons getIcons() {
        return icons;
    }

    public void setIcons(Icons icons) {
        this.icons = icons;
    }

    public String getDocumentationLink() {
        return documentationLink;
    }

    public void setDocumentationLink(String documentationLink) {
        this.documentationLink = documentationLink;
    }

    public Boolean getPreferred() {
        return preferred;
    }

    public void setPreferred(Boolean preferred) {
        this.preferred = preferred;
    }

    public boolean isFavorited() {
        return isFavorited;
    }

    public void setFavorited(boolean favorited) {
        isFavorited = favorited;
    }
}

