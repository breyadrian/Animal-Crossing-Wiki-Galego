package com.example.acwiki.client.DTOs;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;

public class BugsDTO {
    private int id;
    private String file_name;
    private final NameDTO name;
    private final JSONObject availability;
    private Array time_array;
    private int price;
    private int price_flick;
    private String catch_phrase;
    private String museum_phrase;
    private String image_uri;
    private String icon_uri;

    public BugsDTO(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getInt("id");
        this.file_name = jsonObject.getString("file-name");
        this.name = new NameDTO(jsonObject.getJSONObject("name"));
        this.availability = jsonObject.getJSONObject("availability");
        this.price = jsonObject.getInt("price");
        this.price_flick= jsonObject.getInt("price-flick");
        this.catch_phrase = jsonObject.getString("catch-phrase");
        this.museum_phrase = jsonObject.getString("museum-phrase");
        this.image_uri = jsonObject.getString("image_uri");
        this.icon_uri = jsonObject.getString("icon_uri");
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
