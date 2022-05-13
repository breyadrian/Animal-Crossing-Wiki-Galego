package com.example.acwiki.client.DTOs;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ItemDTO {
    private String variant;
    private String body_title;
    private String pattern;
    private String pattern_title;
    private boolean isDiy;
    private boolean canCustomizeBody;
    private boolean canCustomizePattern;
    private int kit_cost;
    private String color1;
    private String color2;
    private String size;
    private String source;
    private String source_detail;
    private String versio;
    private String hha_concept_1;
    private String hha_concept_2;
    private String hha_series;
    private String hha_set;
    private boolean isInteractive;
    private String tag;
    private boolean isOutdoor;
    private String speaker_type;
    private String lighting_type;
    private boolean isDoorDeco;
    private boolean isCatalog;
    private String file_name;
    private String variant_id;
    private int internal_id;
    private final NameDTO name;
    private int buy_price;
    private int sell_price;
    private String image_uri;


    public ItemDTO(JSONObject jsonObject) throws JSONException {
        this.variant = jsonObject.getString("variant");
        this.body_title = jsonObject.getString("body-title");
        this.pattern = jsonObject.getString("pattern");
        this.pattern_title = jsonObject.getString("pattern-title");
        this.isDiy = jsonObject.getBoolean("isDIY");
        this.canCustomizeBody = jsonObject.getBoolean("canCustomizeBody");
        this.canCustomizePattern = jsonObject.getBoolean("canCustomizePattern");
        this.kit_cost = jsonObject.getInt("kit-cost");
        this.color1 = jsonObject.getString("color-1");
        this.color2 = jsonObject.getString("color-2");
        this.size = jsonObject.getString("size");
        this.source = jsonObject.getString("source");
        this.source_detail = jsonObject.getString("source-detail");
        this.versio = jsonObject.getString("version");
        this.hha_concept_1 = jsonObject.getString("hha-concept-1");
        this.hha_concept_2 = jsonObject.getString("hha-concept-2");
        this.hha_series = jsonObject.getString("hha-series");
        this.hha_set = jsonObject.getString("hha-set");
        this.isInteractive = jsonObject.getBoolean("isInteractive");
        this.tag = jsonObject.getString("tag");
        this.isOutdoor = jsonObject.getBoolean("isOutdoor");
        this.speaker_type = jsonObject.getString("speaker-type");
        this.lighting_type = jsonObject.getString("lighting-type");
        this.isDoorDeco = jsonObject.getBoolean("isDoorDeco");
        this.isCatalog = jsonObject.getBoolean("isCatalog");;
        this.file_name = jsonObject.getString("file-name");
        this.variant_id = jsonObject.getString("variant-id");
        this.internal_id = jsonObject.getInt("internal-id");
        this.name = new NameDTO(jsonObject.getJSONObject("name"));
        this.buy_price = jsonObject.getInt("buy-price");
        this.sell_price = jsonObject.getInt("sell-price");
        this.image_uri = jsonObject.getString("image_uri");
    }

    public String getVariant() {
        return variant;
    }

    public String getBody_title() {
        return body_title;
    }

    public String getPattern() {
        return pattern;
    }

    public String getPattern_title() {
        return pattern_title;
    }

    public boolean isDiy() {
        return isDiy;
    }

    public boolean isCanCustomizeBody() {
        return canCustomizeBody;
    }

    public boolean isCanCustomizePattern() {
        return canCustomizePattern;
    }

    public int getKit_cost() {
        return kit_cost;
    }

    public String getColor1() {
        return color1;
    }

    public String getColor2() {
        return color2;
    }

    public String getSize() {
        return size;
    }

    public String getSource() {
        return source;
    }

    public String getSource_detail() {
        return source_detail;
    }

    public String getVersio() {
        return versio;
    }

    public String getHha_concept_1() {
        return hha_concept_1;
    }

    public String getHha_concept_2() {
        return hha_concept_2;
    }

    public String getHha_series() {
        return hha_series;
    }

    public String getHha_set() {
        return hha_set;
    }

    public boolean isInteractive() {
        return isInteractive;
    }

    public String getTag() {
        return tag;
    }

    public boolean isOutdoor() {
        return isOutdoor;
    }

    public String getSpeaker_type() {
        return speaker_type;
    }

    public String getLighting_type() {
        return lighting_type;
    }

    public boolean isDoorDeco() {
        return isDoorDeco;
    }

    public boolean isCatalog() {
        return isCatalog;
    }

    public String getFile_name() {
        return file_name;
    }

    public String getVariant_id() {
        return variant_id;
    }

    public int getInternal_id() {
        return internal_id;
    }

    public NameDTO getName() {
        return name;
    }

    public int getBuy_price() {
        return buy_price;
    }

    public int getSell_price() {
        return sell_price;
    }

    public String getImage_uri() {
        return image_uri;
    }
}