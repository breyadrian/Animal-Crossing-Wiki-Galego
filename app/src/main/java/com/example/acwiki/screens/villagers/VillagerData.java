package com.example.acwiki.screens.villagers;

import android.os.Parcel;
import android.os.Parcelable;

public class VillagerData implements Parcelable {
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

    protected VillagerData(Parcel in) {
        id = in.readInt();
        name = in.readString();
        personality = in.readString();
        birthday_string = in.readString();
        birthday = in.readString();
        species = in.readString();
        gender = in.readString();
        catch_phrase = in.readString();
        image_uri = in.createByteArray();
        icon_uri = in.createByteArray();
    }

    public static final Creator<VillagerData> CREATOR = new Creator<VillagerData>() {
        @Override
        public VillagerData createFromParcel(Parcel in) {
            return new VillagerData(in);
        }

        @Override
        public VillagerData[] newArray(int size) {
            return new VillagerData[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(personality);
        dest.writeString(birthday_string);
        dest.writeString(birthday);
        dest.writeString(species);
        dest.writeString(gender);
        dest.writeString(catch_phrase);
        dest.writeByteArray(image_uri);
        dest.writeByteArray(icon_uri);
    }
}
