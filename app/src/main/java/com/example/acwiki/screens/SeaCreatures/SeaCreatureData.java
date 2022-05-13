package com.example.acwiki.screens.SeaCreatures;

public class SeaCreatureData {

    private int id;
    private String name;
    private String availability;
    private int speed;
    private String shadow;
    private int precio;
    private byte[] image_uri;
    private byte[] icon_uri;

    public SeaCreatureData(int id, String name, String availability, int speed, String shadow, int precio, byte[] image_uri, byte[] icon_uri) {
        this.id = id;
        this.name = name;
        this.availability = availability;
        this.speed = speed;
        this.shadow = shadow;
        this.precio = precio;
        this.image_uri = image_uri;
        this.icon_uri = icon_uri;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvailability() {
        return availability;
    }

    public int getSpeed() {
        return speed;
    }

    public String getShadow() {
        return shadow;
    }

    public int getPrecio() {
        return precio;
    }

    public byte[] getImage_uri() {
        return image_uri;
    }

    public byte[] getIcon_uri() {
        return icon_uri;
    }
}
