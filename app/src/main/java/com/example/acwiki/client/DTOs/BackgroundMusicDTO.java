package com.example.acwiki.client.DTOs;

import org.json.JSONException;
import org.json.JSONObject;

public class BackgroundMusicDTO {

    private int id;
    private String file_name;
    private int hour;
    private String wheather;
    private String music_uri;

    public BackgroundMusicDTO(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getInt("id");
        this.file_name = jsonObject.getString("file-name");
        this.hour = jsonObject.getInt("hour");
        this.wheather = jsonObject.getString("weather");
        this.music_uri = jsonObject.getString("music_uri");

    }

    public int getId() {
        return id;
    }

    public String getFile_name() {
        return file_name;
    }

    public int getHour() {
        return hour;
    }

    public String getWheather() {
        return wheather;
    }

    public String getMusic_uri() {
        return music_uri;
    }
}
