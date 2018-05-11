package com.jyothishjohnson.dmusics.gmail_clone.utils;

public class Model {
    private String sender;
    private String subject;
    private String content;
    private String time;
    private Boolean isStarred;
    private Boolean isBold;
    private String firstLetter;
    private int imageResource;

    public Model(String sender, String subject, String content, String time,
                 Boolean isStarred, Boolean isBold, String firstLetter, int imageResource) {
        this.sender = sender;
        this.subject =subject;
        this.content = content;
        this.time = time;
        this.isStarred = isStarred;
        this.isBold = isBold;
        this.firstLetter = firstLetter;
        this.imageResource = imageResource;
    }

    public String getSender() {
        return sender;
    }

    public String getSubject(){
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public Boolean getStarred() {
        return isStarred;
    }

    public Boolean getBold() {
        return isBold;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setStarred(Boolean starred) {
        isStarred = starred;
    }
}
