package com.example.acwiki.screens.fish;

import android.os.Parcel;
import android.os.Parcelable;

public class FishData implements Parcelable {

    private int id;
    private String name;
    private String availability;
    private String shadow;
    private int precio;
    private int precio_cj;
    private String fraseCaptura;
    private String fraseMuseo;
    private byte[] image_uri;
    private byte[] icon_uri;



    public FishData(int id, String name, String availability, String shadow, int precio, int precio_cj,String fraseCaptura,String fraseMuseo, byte[] image_uri, byte[] icon_uri) {
        this.id = id;
        this.name = name;
        this.availability=availability;
        this.shadow=shadow;
        this.precio=precio;
        this.precio_cj=precio_cj;
        this.fraseCaptura=fraseCaptura;
        this.fraseMuseo=fraseMuseo;
        this.image_uri = image_uri;
        this.icon_uri = icon_uri;
    }

    protected FishData(Parcel in) {
        id = in.readInt();
        name = in.readString();
        availability = in.readString();
        shadow = in.readString();
        precio = in.readInt();
        precio_cj = in.readInt();
        fraseCaptura = in.readString();
        fraseMuseo = in.readString();
        image_uri = in.createByteArray();
        icon_uri = in.createByteArray();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(availability);
        dest.writeString(shadow);
        dest.writeInt(precio);
        dest.writeInt(precio_cj);
        dest.writeString(fraseCaptura);
        dest.writeString(fraseMuseo);
        dest.writeByteArray(image_uri);
        dest.writeByteArray(icon_uri);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FishData> CREATOR = new Creator<FishData>() {
        @Override
        public FishData createFromParcel(Parcel in) {
            return new FishData(in);
        }

        @Override
        public FishData[] newArray(int size) {
            return new FishData[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvailability() {
        return availability;
    }

    public String getShadow() {
        return shadow;
    }

    public int getPrecio() {
        return precio;
    }

    public int getPrecio_cj() {
        return precio_cj;
    }

    public String getFraseCaptura() {
        return fraseCaptura;
    }

    public String getFraseMuseo() {
        return fraseMuseo;
    }

    public byte[] getImage_uri() {
        return image_uri;
    }

    public byte[] getIcon_uri() {
        return icon_uri;
    }
}
