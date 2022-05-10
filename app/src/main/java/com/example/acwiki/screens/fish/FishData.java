package com.example.acwiki.screens.fish;

public class FishData {

    private int id;
    private String name;
    private byte[] image_uri;
    private byte[] icon_uri;

    public FishData(int id, String name, byte[] image_uri, byte[] icon_uri) {
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

    public byte[] getImage_uri() {
        return image_uri;
    }

    public byte[] getIcon_uri() {
        return icon_uri;
    }
}
