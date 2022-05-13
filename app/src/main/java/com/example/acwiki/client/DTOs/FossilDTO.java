package com.example.acwiki.client.DTOs;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FossilDTO {

    private final String file_name;
    private final NameDTO name;
    private int price;
    private String museum_phrase;
    private String image_uri;
    private String part_of;

    public FossilDTO(JSONObject jsonObject) throws JSONException {
        this.file_name = jsonObject.getString("file-name");
        this.name = new NameDTO(jsonObject.getJSONObject("name"));
        this.price = jsonObject.getInt("price");
        this.museum_phrase = jsonObject.getString("museum-phrase");
        this.image_uri = jsonObject.getString("image_uri");
        this.part_of = jsonObject.getString("part-of");
    }


    public String getFile_name() {
        return file_name;
    }

    public NameDTO getName() {
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

    public String getPart_of() {
        return part_of;
    }
}
