package com.example.acwiki.client.DTOs;

import org.json.JSONException;
import org.json.JSONObject;

public class FishDTO {
    private final int id;
    private final String file_name;
    private final NameDTO name;
    private final JSONObject availability;
    private final String shadow;
    private final int price;
    private final int price_cj;
    private final String catch_phrase;
    private final String museum_phrase;
    private final String image_uri;
    private final String icon_uri;

    public FishDTO(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getInt("id");
        this.file_name = jsonObject.getString("file-name");
        this.name = new NameDTO(jsonObject.getJSONObject("name"));
        this.availability = jsonObject.getJSONObject("availability");
        this.shadow = jsonObject.getString("shadow");
        this.price = jsonObject.getInt("price");
        this.price_cj = jsonObject.getInt("price-cj");
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

    public String getShadow() {
        return shadow;
    }

    public int getPrice() {
        return price;
    }

    public int getPrice_cj() {
        return price_cj;
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
