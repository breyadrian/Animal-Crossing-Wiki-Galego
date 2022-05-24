package com.example.acwiki.screens.SeaCreatures;

import android.os.Parcel;
import android.os.Parcelable;

public class SeaCreatureData implements Parcelable{

    private int id;
    private String name;
    private String availability;
    private String speed;
    private String shadow;
    private int precio;
    private String fraseCaptura;
    private String fraseMuseo;
    private byte[] image_uri;
    private byte[] icon_uri;


    public SeaCreatureData(int id, String name, String availability, String speed, String shadow, int precio, String fraseCaptura, String fraseMuseo, byte[] image_uri, byte[] icon_uri) {
        this.id = id;
        this.name = name;
        this.availability = availability;
        this.speed = speed;
        this.shadow = shadow;
        this.precio = precio;
        this.fraseCaptura = fraseCaptura;
        this.fraseMuseo = fraseMuseo;
        this.image_uri = image_uri;
        this.icon_uri = icon_uri;
    }

    protected SeaCreatureData(Parcel in) {
        id = in.readInt();
        name = in.readString();
        availability = in.readString();
        speed = in.readString();
        shadow = in.readString();
        precio = in.readInt();
        fraseCaptura = in.readString();
        fraseMuseo = in.readString();
        image_uri = in.createByteArray();
        icon_uri = in.createByteArray();
    }

    public static final Creator<SeaCreatureData> CREATOR = new Creator<SeaCreatureData>() {
        @Override
        public SeaCreatureData createFromParcel(Parcel in) {
            return new SeaCreatureData(in);
        }

        @Override
        public SeaCreatureData[] newArray(int size) {
            return new SeaCreatureData[size];
        }
    };

    public String getFraseCaptura() {
        return fraseCaptura;
    }

    public String getFraseMuseo() {
        return fraseMuseo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvailability() {
        return availability;
    }

    public String getSpeed() {
        return speed;
    }

    public String getShadow() {
        return shadow;
    }

    public int getPrecio() {
        return precio;
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
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(availability);
        parcel.writeString(speed);
        parcel.writeString(shadow);
        parcel.writeInt(precio);
        parcel.writeString(fraseCaptura);
        parcel.writeString(fraseMuseo);
        parcel.writeByteArray(image_uri);
        parcel.writeByteArray(icon_uri);
    }
}
