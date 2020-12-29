package com.example.listviewexamples.models;

public class CustomItemModel {
    int avatarResource;
    String title;
    String subtitle;
    boolean selected;

    public CustomItemModel(int avatarResource, String title, String subtitle) {
        this.avatarResource = avatarResource;
        this.title = title;
        this.subtitle = subtitle;
        this.selected = false;
    }

    public int getAvatarResource() {
        return avatarResource;
    }

    public void setAvatarResource(int avatarResource) {
        this.avatarResource = avatarResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
