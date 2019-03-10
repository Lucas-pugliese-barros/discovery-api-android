package com.barros.pugliese.discoveryapiandroid.dto;

import com.google.gson.annotations.SerializedName;

public class ApiDTO {

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
    private IconsDTO iconsDTO;

    @SerializedName("documentationLink")
    private String documentationLink;

    @SerializedName("preferred")
    private Boolean preferred;

    private boolean isFavorited = false;

    public ApiDTO() {
    }

    public ApiDTO(String id, String kind, String name, String version, String title, String description,
                  String discoveryRestUrl, IconsDTO iconsDTO, String documentationLink, Boolean preferred,
                  boolean isFavorited) {

        this.id = id;
        this.kind = kind;
        this.name = name;
        this.version = version;
        this.title = title;
        this.description = description;
        this.discoveryRestUrl = discoveryRestUrl;
        this.iconsDTO = iconsDTO;
        this.documentationLink = documentationLink;
        this.preferred = preferred;
        this.isFavorited = isFavorited;
    }

    public ApiDTO(String id, String kind, String name, String version, String title, String description,
                  String discoveryRestUrl, String documentationLink, boolean isFavorited) {

        this.id = id;
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

    public IconsDTO getIconsDTO() {
        return iconsDTO;
    }

    public void setIconsDTO(IconsDTO iconsDTO) {
        this.iconsDTO = iconsDTO;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApiDTO apiDTO = (ApiDTO) o;

        if(getId().equals(apiDTO.getId()))
            return true;

        if (!getId().equals(apiDTO.getId())) return false;
        if (isFavorited() != apiDTO.isFavorited()) return false;
        if (getKind() != null ? !getKind().equals(apiDTO.getKind()) : apiDTO.getKind() != null)
            return false;
        if (getName() != null ? !getName().equals(apiDTO.getName()) : apiDTO.getName() != null)
            return false;
        if (getVersion() != null ? !getVersion().equals(apiDTO.getVersion()) : apiDTO.getVersion() != null)
            return false;
        if (getTitle() != null ? !getTitle().equals(apiDTO.getTitle()) : apiDTO.getTitle() != null)
            return false;
        if (getDescription() != null ? !getDescription().equals(apiDTO.getDescription()) : apiDTO.getDescription() != null)
            return false;
        if (getDiscoveryRestUrl() != null ? !getDiscoveryRestUrl().equals(apiDTO.getDiscoveryRestUrl()) : apiDTO.getDiscoveryRestUrl() != null)
            return false;
        if (getIconsDTO() != null ? !getIconsDTO().equals(apiDTO.getIconsDTO()) : apiDTO.getIconsDTO() != null)
            return false;
        if (getDocumentationLink() != null ? !getDocumentationLink().equals(apiDTO.getDocumentationLink()) : apiDTO.getDocumentationLink() != null)
            return false;
        return getPreferred() != null ? getPreferred().equals(apiDTO.getPreferred()) : apiDTO.getPreferred() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getKind() != null ? getKind().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getVersion() != null ? getVersion().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getDiscoveryRestUrl() != null ? getDiscoveryRestUrl().hashCode() : 0);
        result = 31 * result + (getIconsDTO() != null ? getIconsDTO().hashCode() : 0);
        result = 31 * result + (getDocumentationLink() != null ? getDocumentationLink().hashCode() : 0);
        result = 31 * result + (getPreferred() != null ? getPreferred().hashCode() : 0);
        result = 31 * result + (isFavorited() ? 1 : 0);
        return result;
    }
}

