package com.example.acwiki.DTOs;

import java.util.ArrayList;

public class FossilDTO {
    private int id;
    private String file_name;
    private ArrayList name;
    private int price;
    private String museum_phrase;
    private String image_uri;

    public FossilDTO(int id, String file_name, ArrayList name, int price, String museum_phrase, String image_uri) {
        this.id = id;
        this.file_name = file_name;
        this.name = name;
        this.price = price;
        this.museum_phrase = museum_phrase;
        this.image_uri = image_uri;
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

    public int getPrice() {
        return price;
    }

    public String getMuseum_phrase() {
        return museum_phrase;
    }

    public String getImage_uri() {
        return image_uri;
    }
}
