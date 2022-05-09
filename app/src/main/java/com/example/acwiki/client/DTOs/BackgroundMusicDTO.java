package com.example.acwiki.client.DTOs;

public class BackgroundMusicDTO {

    private int id;
    private String file_name;
    private int hour;
    private String wheather;

    public BackgroundMusicDTO(int id, String file_name, int hour, String wheather) {
        this.id = id;
        this.file_name = file_name;
        this.hour = hour;
        this.wheather = wheather;
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
}
