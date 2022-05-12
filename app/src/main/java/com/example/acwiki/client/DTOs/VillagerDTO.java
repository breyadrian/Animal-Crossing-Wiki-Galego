package com.example.acwiki.client.DTOs;

import org.json.JSONException;
import org.json.JSONObject;

public class VillagerDTO {

    private final int id;
    private final String file_name;
    private final NameDTO name;
    private final String personality;
    private final String birthday_string;
    private final String birthday;
    private final String species;
    private final String gender;
    private final String catch_phrase;
    private final String icon_uri;
    private final String image_uri;

    public VillagerDTO(JSONObject jsonObject) throws JSONException {
        this.id =  jsonObject.getInt("id");
        this.file_name = jsonObject.getString("file-name");
        this.name = new NameDTO(jsonObject.getJSONObject("name"));
        this.personality = jsonObject.getString("personality");
        this.birthday_string = jsonObject.getString("birthday-string");
        this.birthday = jsonObject.getString("birthday");
        this.species = jsonObject.getString("species");
        this.gender =jsonObject.getString("gender") ;
        this.catch_phrase = jsonObject.getString("catch-phrase");
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

    public String getPersonality() {
        return personality;
    }

    public String getBirthday_string() {
        return birthday_string;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getSpecies() {
        return species;
    }

    public String getGender() {
        return gender;
    }

    public String getCatch_phrase() {
        return catch_phrase;
    }

    public String getIcon_uri() {
        return icon_uri;
    }

    public String getImage_uri() {
        return image_uri;
    }
}
