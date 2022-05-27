package com.example.acwiki.client.DTOs;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ArtDTO {
    private int id;
    private String file_name;
    private NameDTO name;
    private boolean hasFake;
    private int buy_price;
    private int sell_price;
    private String image_uri;
    private String museum_desc;

    public ArtDTO(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getInt("id");
        this.file_name = jsonObject.getString("file-name");
        this.name = new NameDTO(jsonObject.getJSONObject("name"));
        this.hasFake = jsonObject.getBoolean("hasFake");
        this.buy_price = jsonObject.getInt("buy-price");
        this.sell_price = jsonObject.getInt("sell-price");
        this.image_uri = jsonObject.getString("image_uri");
        this.museum_desc = jsonObject.getString("museum-desc");
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

    public boolean HasFake() {
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
