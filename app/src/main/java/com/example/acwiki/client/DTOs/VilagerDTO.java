package com.example.acwiki.client.DTOs;

import java.util.ArrayList;

public class VilagerDTO {

    private int id;
    private String file_name;
    private ArrayList name;
    private String personality;
    private String birthday_string;
    private String birthday;
    private String species;
    private String gender;
    private String catch_phrase;
    private String icon;
    private String image;

    public VilagerDTO(int id, String file_name, ArrayList name, String personality, String birthday_string, String birthday, String species, String gender, String catch_phrase, String icon, String image) {
        this.id = id;
        this.file_name = file_name;
        this.name = name;
        this.personality = personality;
        this.birthday_string = birthday_string;
        this.birthday = birthday;
        this.species = species;
        this.gender = gender;
        this.catch_phrase = catch_phrase;
        this.icon = icon;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getFile_name() {
        return file_name;
    }

    public ArrayList getName() {
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

    public String getIcon() {
        return icon;
    }

    public String getImage() {
        return image;
    }
}
