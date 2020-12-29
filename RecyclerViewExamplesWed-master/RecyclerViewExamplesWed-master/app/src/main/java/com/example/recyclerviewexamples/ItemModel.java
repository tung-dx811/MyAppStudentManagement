package com.example.recyclerviewexamples;

public class ItemModel {
    int thumbnailResource;
    String title;

    public ItemModel(int thumbnailResource, String title) {
        this.thumbnailResource = thumbnailResource;
        this.title = title;
    }

    public int getThumbnailResource() {
        return thumbnailResource;
    }

    public void setThumbnailResource(int thumbnailResource) {
        this.thumbnailResource = thumbnailResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
