package com.example.acwiki.client.DTOs;

import java.util.ArrayList;

public class ArtDTO {
    private int id;
    private String file_name;
    private ArrayList name;
    private boolean hasFake;
    private int buy_price;
    private int sell_price;
    private String image_uri;
    private String museum_desc;

    public ArtDTO(int id, String file_name, ArrayList name, boolean hasFake, int buy_price, int sell_price, String image_uri, String museum_desc) {
        this.id = id;
        this.file_name = file_name;
        this.name = name;
        this.hasFake = hasFake;
        this.buy_price = buy_price;
        this.sell_price = sell_price;
        this.image_uri = image_uri;
        this.museum_desc = museum_desc;
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

    public boolean isHasFake() {
        return hasFake;
    }

    public int getBuy_price() {
        return buy_price;
    }

    public int getSell_price() {
        return sell_price;
    }

    public String getImage_uri() {
        return image_uri;
    }

    public String getMuseum_desc() {
        return museum_desc;
    }
}
