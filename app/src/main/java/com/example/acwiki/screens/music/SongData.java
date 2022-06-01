package com.example.acwiki.screens.music;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.acwiki.client.DTOs.NameDTO;

public class SongData implements Parcelable{
    private int id;
    private String file_name;
    private String name;
    private int buy_price;
    private int sell_price;
    private String isOrderable;
    private byte[] image_uri;



    public SongData(int id, String file_name, String name, int buy_price, int sell_price, String isOrderable, byte[] image_uri) {
        this.id = id;
        this.file_name = file_name;
        this.name = name;
        this.buy_price = buy_price;
        this.sell_price = sell_price;
        this.isOrderable = isOrderable;
        this.image_uri = image_uri;
    }

    protected SongData(Parcel in) {
        id = in.readInt();
        file_name = in.readString();
        name = in.readString();
        buy_price = in.readInt();
        sell_price = in.readInt();
        isOrderable = in.readString();
        image_uri = in.createByteArray();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(file_name);
        dest.writeString(name);
        dest.writeInt(buy_price);
        dest.writeInt(sell_price);
        dest.writeString(isOrderable);
        dest.writeByteArray(image_uri);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SongData> CREATOR = new Creator<SongData>() {
        @Override
        public SongData createFromParcel(Parcel in) {
            return new SongData(in);
        }

        @Override
        public SongData[] newArray(int size) {
            return new SongData[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getFile_name() {
        return file_name;
    }

    public String getName() {
        return name;
    }

    public int getBuy_price() {
        return buy_price;
    }

    public int getSell_price() {
        return sell_price;
    }

    public String getIsOrderable() {
        return isOrderable;
    }

    public byte[] getImage_uri() {
        return image_uri;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBuy_price(int buy_price) {
        this.buy_price = buy_price;
    }

    public void setSell_price(int sell_price) {
        this.sell_price = sell_price;
    }

    public void setIsOrderable(String isOrderable) {
        this.isOrderable = isOrderable;
    }

    public void setImage_uri(byte[] image_uri) {
        this.image_uri = image_uri;
    }

}
