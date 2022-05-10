package com.example.acwiki.screens.fish;

public class FishData {

    private int id;
    private String name;
    private String abaliability;
    private String shadow;
    private int precio;
    private int precio_cj;
    private byte[] image_uri;
    private byte[] icon_uri;



    public FishData(int id, String name, String abaliability, String shadow, int precio, int precio_cj, byte[] image_uri, byte[] icon_uri) {
        this.id = id;
        this.name = name;
        this.abaliability=abaliability;
        this.shadow=shadow;
        this.precio=precio;
        this.precio_cj=precio_cj;
        this.image_uri = image_uri;
        this.icon_uri = icon_uri;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAbaliability() {
        return abaliability;
    }

    public String getShadow() {
        return shadow;
    }

    public int getPrecio() {
        return precio;
    }

    public int getPrecio_cj() {
        return precio_cj;
    }

    public byte[] getImage_uri() {
        return image_uri;
    }

    public byte[] getIcon_uri() {
        return icon_uri;
    }
}
