package com.example.acwiki.client.DTOs;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SongDTO {
    private int id;
    private String file_name;
    private NameDTO name;
    private int buy_price;
    private int sell_price;
    private boolean isOrderable;
    private String music_uri;
    private String image_uri;

    public SongDTO(JSONObject jsonObject) throws JSONException {
        this.id =jsonObject.getInt("id");
        this.file_name =  jsonObject.getString("file-name");
        this.name = new NameDTO(jsonObject.getJSONObject("name"));
        this.buy_price = jsonObject.optInt("buy-price");
        this.sell_price = jsonObject.getInt("sell-price");
        this.isOrderable = jsonObject.getBoolean("isOrderable");
        this.music_uri = jsonObject.getString("music_uri");
        this.image_uri = jsonObject.getString("image_uri");
    }
    public int getId() {
        return id;
    }

    public String getFile_name() {
        return file_name;
    }

    public NameDTO getName() {
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
