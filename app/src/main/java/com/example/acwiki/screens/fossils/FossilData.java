package com.example.acwiki.screens.fossils;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.acwiki.client.DTOs.NameDTO;

public class FossilData  implements Parcelable {


    private String name;
    private int price;
    private String museum_phrase;
    private byte[] image_uri;
    private String part_of;


    public FossilData(String name, int price, String museum_phrase, byte[] image_uri, String part_of) {
        this.name = name;
        this.price = price;
        this.museum_phrase = museum_phrase;
        this.image_uri = image_uri;
        this.part_of = part_of;
    }

    protected FossilData(Parcel in) {
        name = in.readString();
        price = in.readInt();
        museum_phrase = in.readString();
        image_uri = in.createByteArray();
        part_of = in.readString();
    }

    public static final Creator<FossilData> CREATOR = new Creator<FossilData>() {
        @Override
        public FossilData createFromParcel(Parcel in) {
            return new FossilData(in);
        }

        @Override
        public FossilData[] newArray(int size) {
            return new FossilData[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getMuseum_phrase() {
        return museum_phrase;
    }

    public byte[] getImage_uri() {
        return image_uri;
    }

    public String getPart_of() {
        return part_of;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(price);
        parcel.writeString(museum_phrase);
        parcel.writeByteArray(image_uri);
        parcel.writeString(part_of);
    }
}
