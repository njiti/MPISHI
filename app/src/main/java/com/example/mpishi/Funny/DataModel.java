package com.example.mpishi.Funny;

public class DataModel {
    private String imageUrl;
    //Constructor
    public DataModel(String imageUrl){
        this.imageUrl = imageUrl;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }
}