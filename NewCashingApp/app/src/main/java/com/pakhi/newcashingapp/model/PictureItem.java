package com.pakhi.newcashingapp.model;

public class PictureItem {
    private String id;
    private String author;
    private String imageUrl;

    public PictureItem(String id, String author, String imageUrl) {
        this.id = id;
        this.author = author;
        this.imageUrl = imageUrl;
    }

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
