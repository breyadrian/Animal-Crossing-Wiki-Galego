package com.example.acwiki.screens.bugs;

public class BugsData {


    private int id;
    private String name;
    private String availability;
    private String shadow;
    private int precio;
    private int precio_flick;
    private byte[] image_uri;
    private byte[] icon_uri;

    public BugsData(int id, String name, String availability, String shadow, int precio, int precio_flick, byte[] image_uri, byte[] icon_uri) {
        this.id = id;
        this.name = name;
        this.availability = availability;
        this.shadow = shadow;
        this.precio = precio;
        this.precio_flick = precio_flick;
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

    public String getShadow() {
        return shadow;
    }

    public int getPrecio() {
        return precio;
    }

    public int getPrecio_flick() {
        return precio_flick;
    }

    public byte[] getImage_uri() {
        return image_uri;
    }

    public byte[] getIcon_uri() {
        return icon_uri;
    }
}
