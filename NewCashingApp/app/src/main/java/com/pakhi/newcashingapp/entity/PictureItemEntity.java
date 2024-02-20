package com.pakhi.newcashingapp.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "picture_items")
public class PictureItemEntity {
    @PrimaryKey()
    private @NonNull String id;
    private String author;
    private String imageUrl;

    public PictureItemEntity(@NonNull String id, String author, String imageUrl) {
        this.id = id;
        this.author = author;
        this.imageUrl = imageUrl;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
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
