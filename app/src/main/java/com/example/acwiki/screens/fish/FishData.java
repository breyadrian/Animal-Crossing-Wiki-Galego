package com.example.acwiki.screens.fish;

public class FishData {

    private int id;
    private String name;
    private String image_uri;
    private String icon_uri;

    public FishData(int id, String name, String image_uri, String icon_uri) {
        this.id = id;
        this.name = name;
        this.image_uri = image_uri;
        this.icon_uri = icon_uri;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage_uri() {
        return image_uri;
    }

    public String getIcon_uri() {
        return icon_uri;
    }
}
