package com.example.acwiki.DTOs;

public class HourlyMusicDTO {

    private String song_uri;

    public HourlyMusicDTO(String song_uri) {
        this.song_uri = song_uri;
    }

    public String getSong_uri() {
        return song_uri;
    }
}
