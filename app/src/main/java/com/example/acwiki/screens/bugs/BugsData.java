package com.example.acwiki.screens.bugs;

import android.os.Parcel;
import android.os.Parcelable;

public class BugsData implements Parcelable {


    private int id;
    private String name;
    private String availability;

    private int precio;
    private int precio_flick;
    private String fraseCaptura;
    private String fraseMuseo;
    private byte[] image_uri;
    private byte[] icon_uri;

    public BugsData(int id, String name, String availability, int precio, int precio_flick, String fraseCaptura, String fraseMuseo, byte[] image_uri, byte[] icon_uri) {
        this.id = id;
        this.name = name;
        this.availability = availability;
        this.precio = precio;
        this.precio_flick = precio_flick;
        this.fraseCaptura = fraseCaptura;
        this.fraseMuseo = fraseMuseo;
        this.image_uri = image_uri;
        this.icon_uri = icon_uri;
    }

    protected BugsData(Parcel in) {
        id = in.readInt();
        name = in.readString();
        availability = in.readString();
        precio = in.readInt();
        precio_flick = in.readInt();
        fraseCaptura=in.readString();
        fraseMuseo=in.readString();
        image_uri = in.createByteArray();
        icon_uri = in.createByteArray();
    }

    public static final Creator<BugsData> CREATOR = new Creator<BugsData>() {
        @Override
        public BugsData createFromParcel(Parcel in) {
            return new BugsData(in);
        }

        @Override
        public BugsData[] newArray(int size) {
            return new BugsData[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFraseCaptura() {
        return fraseCaptura;
    }

    public String getFraseMuseo() {
        return fraseMuseo;
    }

    public String getAvailability() {
        return availability;
    }


    public int getPrecio() {
        return precio;
    }

    public int getPrecio_flick() {
        return precio_flick;
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
        parcel.writeInt(precio);
        parcel.writeInt(precio_flick);
        parcel.writeString(fraseCaptura);
        parcel.writeString(fraseMuseo);
        parcel.writeByteArray(image_uri);
        parcel.writeByteArray(icon_uri);
    }
}
