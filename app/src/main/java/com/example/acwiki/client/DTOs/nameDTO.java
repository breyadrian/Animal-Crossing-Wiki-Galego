package com.example.acwiki.client.DTOs;

import org.json.JSONException;
import org.json.JSONObject;

public class nameDTO {
    private String nameEUen;
    private String nameEUde;
    private String nameEUes;
    private String nameUSes;
    private String nameEUfr;
    private String nameUSfr;
    private String nameEUit;
    private String nameEUnl;
    private String nameCNzh;
    private String nameTWzh;
    private String nameJPja;
    private String nameKRko;
    private String nameEUru;

    public nameDTO(JSONObject jsonObject) throws JSONException {
        this.nameEUen = jsonObject.getString("name-EUen");
        this.nameEUde = jsonObject.getString("name-EUde");
        this.nameEUes = jsonObject.getString("name-EUes");
        this.nameUSes = jsonObject.getString("name-USes");
        this.nameEUfr = jsonObject.getString("name-EUfr");
        this.nameUSfr = jsonObject.getString("name-USfr");
        this.nameEUit = jsonObject.getString("name-EUit");
        this.nameEUnl = jsonObject.getString("name-EUnl");
        this.nameCNzh = jsonObject.getString("name-CNzh");
        this.nameTWzh = jsonObject.getString("name-TWzh");
        this.nameJPja = jsonObject.getString("name-JPja");
        this.nameKRko = jsonObject.getString("name-KRko");
        this.nameEUru = jsonObject.getString("name-EUru");
    }

    public String getNameEUen() {
        return nameEUen;
    }

    public String getNameEUde() {
        return nameEUde;
    }

    public String getNameEUes() {
        return nameEUes;
    }

    public String getNameUSes() {
        return nameUSes;
    }

    public String getNameEUfr() {
        return nameEUfr;
    }

    public String getNameUSfr() {
        return nameUSfr;
    }

    public String getNameEUit() {
        return nameEUit;
    }

    public String getNameEUnl() {
        return nameEUnl;
    }

    public String getNameCNzh() {
        return nameCNzh;
    }

    public String getNameTWzh() {
        return nameTWzh;
    }

    public String getNameJPja() {
        return nameJPja;
    }

    public String getNameKRko() {
        return nameKRko;
    }

    public String getNameEUru() {
        return nameEUru;
    }
}
