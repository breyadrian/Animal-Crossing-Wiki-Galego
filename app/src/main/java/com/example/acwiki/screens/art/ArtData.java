package com.example.acwiki.screens.art;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.acwiki.client.DTOs.NameDTO;

public class ArtData implements Parcelable {

    private int id;
    private String name;
    private String hasFake;
    private int buy_price;
    private int sell_price;
    private byte[] image_uri;
    private String museum_desc;

    public ArtData(int id, String name, String hasFake, int buy_price, int sell_price,  byte[] image_uri, String museum_desc) {
        this.id = id;
        this.name = name;
        this.hasFake = hasFake;
        this.buy_price = buy_price;
        this.sell_price = sell_price;
        this.image_uri = image_uri;
        this.museum_desc = museum_desc;
    }

    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public String isHasFake() {
        return hasFake;
    }

    public int getBuy_price() {
        return buy_price;
    }

    public int getSell_price() {
        return sell_price;
    }

    public byte[] getImage_uri() {
        return image_uri;
    }

    public String getMuseum_desc() {
        return museum_desc;
    }

    protected ArtData(Parcel in) {
        id = in.readInt();
        hasFake = in.readString();
        buy_price = in.readInt();
        sell_price = in.readInt();
        image_uri = in.createByteArray();
        museum_desc = in.readString();
    }

    public static final Creator<ArtData> CREATOR = new Creator<ArtData>() {
        @Override
        public ArtData createFromParcel(Parcel in) {
            return new ArtData(in);
        }

        @Override
        public ArtData[] newArray(int size) {
            return new ArtData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(hasFake);
        parcel.writeInt(buy_price);
        parcel.writeInt(sell_price);
        parcel.writeByteArray(image_uri);
        parcel.writeString(museum_desc);
    }
}
