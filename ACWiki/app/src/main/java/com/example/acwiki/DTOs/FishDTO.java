package com.example.acwiki.DTOs;

import java.util.ArrayList;

public class FishDTO {
    private int id;
    private String file_name;
    private ArrayList name;
    private ArrayList avalability;
    private String shadow;
    private int price;
    private int price_cj;
    private String catch_phrase;
    private String museum_phrase;
    private String image_uri;
    private String icon_uri;

    public FishDTO(int id, String file_name, ArrayList name, ArrayList avalability, String shadow, int price, int price_cj, String catch_phrase, String museum_phrase, String image_uri, String icon_uri) {
        this.id = id;
        this.file_name = file_name;
        this.name = name;
        this.avalability = avalability;
        this.shadow = shadow;
        this.price = price;
        this.price_cj = price_cj;
        this.catch_phrase = catch_phrase;
        this.museum_phrase = museum_phrase;
        this.image_uri = image_uri;
        this.icon_uri = icon_uri;
    }

    public int getId() {
        return id;
    }

    public String getFile_name() {
        return file_name;
    }

    public ArrayList getName() {
        return name;
    }

    public ArrayList getAvalability() {
        return avalability;
    }

    public String getShadow() {
        return shadow;
    }

    public int getPrice() {
        return price;
    }

    public int getPrice_cj() {
        return price_cj;
    }

    public String getCatch_phrase() {
        return catch_phrase;
    }

    public String getMuseum_phrase() {
        return museum_phrase;
    }

    public String getImage_uri() {
        return image_uri;
    }

    public String getIcon_uri() {
        return icon_uri;
    }
}
