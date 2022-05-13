package com.example.acwiki.client.DTOs;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SeaCreaturesDTO {
    private int id;
    private String file_name;
    private final NameDTO name;
    private final JSONObject availability;
    private String speed;
    private String shadow;
    private int price;
    private String catch_phrase;
    private String image_uri;
    private String icon_uri;
    private String museum_phrase;

    public SeaCreaturesDTO(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getInt("id");
        this.file_name = jsonObject.getString("file-name");
        this.name = new NameDTO(jsonObject.getJSONObject("name"));
        this.availability = jsonObject.getJSONObject("availability");
        this.speed = jsonObject.getString("speed");
        this.shadow = jsonObject.getString("shadow");
        this.price = jsonObject.getInt("price");
        this.catch_phrase =jsonObject.getString("catch-phrase");
        this.image_uri = jsonObject.getString("image_uri");
        this.icon_uri = jsonObject.getString("icon_uri");
        this.museum_phrase = jsonObject.getString("museum-phrase");


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

    public JSONObject getAvailability() {
        return availability;
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
