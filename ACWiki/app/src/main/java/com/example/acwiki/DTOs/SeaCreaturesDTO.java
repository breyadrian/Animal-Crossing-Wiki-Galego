package com.example.acwiki.DTOs;

import java.util.ArrayList;

public class SeaCreaturesDTO {
    private int id;
    private String file_name;
    private ArrayList name;
    private ArrayList avalability;
    private String speed;
    private String shadow;
    private int price;
    private String catch_phrase;
    private String image_uri;
    private String icon_uri;
    private String museum_phrase;

    public SeaCreaturesDTO(int id, String file_name, ArrayList name, ArrayList avalability, String speed, String shadow, int price, String catch_phrase, String image_uri, String icon_uri, String museum_phrase) {
        this.id = id;
        this.file_name = file_name;
        this.name = name;
        this.avalability = avalability;
        this.speed = speed;
        this.shadow = shadow;
        this.price = price;
        this.catch_phrase = catch_phrase;
        this.image_uri = image_uri;
        this.icon_uri = icon_uri;
        this.museum_phrase = museum_phrase;
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

    public String getSpeed() {
        return speed;
    }

    public String getShadow() {
        return shadow;
    }

    public int getPrice() {
        return price;
    }

    public String getCatch_phrase() {
        return catch_phrase;
    }

    public String getImage_uri() {
        return image_uri;
    }

    public String getIcon_uri() {
        return icon_uri;
    }

    public String getMuseum_phrase() {
        return museum_phrase;
    }
}
