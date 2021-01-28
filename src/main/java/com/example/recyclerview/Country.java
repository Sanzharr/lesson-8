package com.example.recyclerview;

public class Country {
    int photo;
    String title;
    int code;

    public Country(int photo, String title, int code){
        this.photo = photo;
        this.title = title;
        this.code = code;
    }

    public int getPhoto() {
        return photo;
    }

    public String getTitle() {
        return title;
    }

    public int getCode() {
        return code;
    }
}
