package com.example.acwiki.screens.villagers;

public class VillagerData {
    private int id;
    private String name;
    private String personality;
    private String birthday_string;
    private String birthday;
    private String species;
    private String gender;
    private String catch_phrase;
    private byte[] image_uri;
    private byte[] icon_uri;

    public VillagerData(int id, String name, String personality, String birthday_string, String birthday, String species, String gender, String catch_phrase, byte[] image_uri, byte[] icon_uri) {
        this.id = id;
        this.name = name;
        this.personality = personality;
        this.birthday_string = birthday_string;
        this.birthday = birthday;
        this.species = species;
        this.gender = gender;
        this.catch_phrase = catch_phrase;
        this.image_uri = image_uri;
        this.icon_uri = icon_uri;
    }

    public int getId() {
        return id;
    }

    public String getName() {
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

    public byte[] getImage_uri() {
        return image_uri;
    }

    public byte[] getIcon_uri() {
        return icon_uri;
    }
}
