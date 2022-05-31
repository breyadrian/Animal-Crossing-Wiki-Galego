package com.example.acwiki.screens.music;

import android.os.Parcel;
import android.os.Parcelable;

public class MusicData  implements Parcelable {

    private int id;
    private int hour;
    private String wheather;


    public MusicData(int id, int hour, String wheather) {
        this.id = id;
        this.hour = hour;
        this.wheather = wheather;

    }

    protected MusicData(Parcel in) {
        id = in.readInt();
        hour = in.readInt();
        wheather = in.readString();

    }

    public int getId() {
        return id;
    }

    public int getHour() {
        return hour;
    }

    public String getWheather() {
        return wheather;
    }



    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(hour);
        dest.writeString(wheather);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MusicData> CREATOR = new Creator<MusicData>() {
        @Override
        public MusicData createFromParcel(Parcel in) {
            return new MusicData(in);
        }

        @Override
        public MusicData[] newArray(int size) {
            return new MusicData[size];
        }
    };
}
