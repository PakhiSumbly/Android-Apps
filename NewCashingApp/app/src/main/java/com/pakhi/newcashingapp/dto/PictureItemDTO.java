package com.pakhi.newcashingapp.dto;

import com.google.gson.annotations.SerializedName;


public class PictureItemDTO {
    @SerializedName("id")
    private String id;
    @SerializedName("author")
    private String author;
    @SerializedName("download_url")
    private String imageUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
