package com.example.acwiki.screens.fossils;

import com.example.acwiki.client.DTOs.NameDTO;

public class FossilData {


    private String name;
    private int price;
    private String museum_phrase;
    private byte[] image_uri;
    private String part_of;


    public FossilData(String name, int price, String museum_phrase, byte[] image_uri, String part_of) {
        this.name = name;
        this.price = price;
        this.museum_phrase = museum_phrase;
        this.image_uri = image_uri;
        this.part_of = part_of;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getMuseum_phrase() {
        return museum_phrase;
    }

    public byte[] getImage_uri() {
        return image_uri;
    }

    public String getPart_of() {
        return part_of;
    }
}
