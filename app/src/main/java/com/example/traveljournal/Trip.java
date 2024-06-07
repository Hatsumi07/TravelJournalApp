package com.example.traveljournal;

public class Trip {
    private String key, title, date, desc;

    public Trip(String key, String title, String date, String desc) {
        this.key = key;
        this.title = title;
        this.date = date;
        this.desc = desc;
    }

    //reads data from firebase database
    public Trip() {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
