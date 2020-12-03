package com.app.galleryapp;

public class ItemObject {
    private String title;
    private String img_url;


    public ItemObject(String title, String url){
        this.title = title;
        this.img_url = url;
    }


    public String getTitle() {
        return title;
    }

    public String getImg_url() {
        return img_url;
    }
}
