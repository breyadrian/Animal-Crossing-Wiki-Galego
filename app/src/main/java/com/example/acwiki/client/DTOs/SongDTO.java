package com.example.acwiki.client.DTOs;

import java.util.ArrayList;

public class SongDTO {
    private int id;
    private String file_name;
    private ArrayList name;
    private int buy_price;
    private int sell_price;
    private boolean isOrderable;
    private String music_uri;
    private String image_uri;

    public SongDTO(int id, String file_name, ArrayList name, int buy_price, int sell_price, boolean isOrderable, String music_uri, String image_uri) {
        this.id = id;
        this.file_name = file_name;
        this.name = name;
        this.buy_price = buy_price;
        this.sell_price = sell_price;
        this.isOrderable = isOrderable;
        this.music_uri = music_uri;
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

    public int getBuy_price() {
        return buy_price;
    }

    public int getSell_price() {
        return sell_price;
    }

    public boolean isOrderable() {
        return isOrderable;
    }

    public String getMusic_uri() {
        return music_uri;
    }

    public String getImage_uri() {
        return image_uri;
    }

}
