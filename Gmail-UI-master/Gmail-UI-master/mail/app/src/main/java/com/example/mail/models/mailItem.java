package com.example.mail.models;

import java.sql.Time;

public class mailItem {
    String sender;
    String text;
    Time timeSended;
    boolean star;
    String avatarColor;

    public mailItem(String sender, String text, Time timeSended, boolean star, String avatarColor) {
        this.sender = sender;
        this.text = text;
        this.timeSended = timeSended;
        this.star = star;
        this.avatarColor = avatarColor;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Time getTimeSended() {
        return timeSended;
    }

    public String getAvatarColor() {
        return avatarColor;
    }

    public void setAvatarColor(String avatarColor) {
        this.avatarColor = avatarColor;
    }

    public void setTimeSended(Time timeSended) {
        this.timeSended = timeSended;
    }

    public boolean isStar() {
        return star;
    }

    public void setStar(boolean star) {
        this.star = star;
    }
}
