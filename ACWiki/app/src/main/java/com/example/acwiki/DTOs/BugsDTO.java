package com.example.acwiki.DTOs;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BugsDTO {
    private int id;
    private String file_name;
    private ArrayList name;
    private ArrayList availability;
    private Array time_array;
    private int price;
    private int price_flick;
    private String catch_phrase;
    private String museum_phrase;
    private String image_uri;
    private String icon_uri;

    public BugsDTO(int id, String file_name, ArrayList name, ArrayList availability, Array time_array, int price, int price_flick, String catch_phrase, String museum_phrase, String image_uri, String icon_uri) {
        this.id = id;
        this.file_name = file_name;
        this.name = name;
        this.availability = availability;
        this.time_array = time_array;
        this.price = price;
        this.price_flick = price_flick;
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

    public ArrayList getAvailability() {
        return availability;
    }

    public Array getTime_array() {
        return time_array;
    }

    public int getPrice() {
        return price;
    }

    public int getPrice_flick() {
        return price_flick;
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
