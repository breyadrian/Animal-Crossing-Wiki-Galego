package com.example.acwiki.screens.items;

import com.example.acwiki.client.DTOs.NameDTO;

public class ItemData {
    private int appID;
    private String variant;
    private String body_title;
    private String pattern;
    private String pattern_title;
    private String isDiy;
    private String canCustomizeBody;
    private String canCustomizePattern;
    private int kit_cost;
    private String color1;
    private String color2;
    private String size;
    private String source;
    private String source_detail;
    private String version;
    private String hha_concept_1;
    private String hha_concept_2;
    private String hha_series;
    private String hha_set;
    private String isInteractive;
    private String tag;
    private String isOutdoor;
    private String speaker_type;
    private String lighting_type;
    private String isDoorDeco;
    private String isCatalog;
    private String file_name;
    private String variant_id;
    private int internal_id;
    private String name;
    private int buy_price;
    private int sell_price;
    private byte[] image_uri;

    public ItemData(int appID,String variant, String body_title, String pattern, String pattern_title, String isDiy, String canCustomizeBody, String canCustomizePattern, int kit_cost, String color1, String color2, String size, String source, String source_detail, String version, String hha_concept_1, String hha_concept_2, String hha_series, String hha_set, String isInteractive, String tag, String isOutdoor, String speaker_type, String lighting_type, String isDoorDeco, String isCatalog, String file_name, String variant_id, int internal_id, String name, int buy_price, int sell_price, byte[] image_uri) {
        this.appID=appID;
        this.variant = variant;
        this.body_title = body_title;
        this.pattern = pattern;
        this.pattern_title = pattern_title;
        this.isDiy = isDiy;
        this.canCustomizeBody = canCustomizeBody;
        this.canCustomizePattern = canCustomizePattern;
        this.kit_cost = kit_cost;
        this.color1 = color1;
        this.color2 = color2;
        this.size = size;
        this.source = source;
        this.source_detail = source_detail;
        this.version = version;
        this.hha_concept_1 = hha_concept_1;
        this.hha_concept_2 = hha_concept_2;
        this.hha_series = hha_series;
        this.hha_set = hha_set;
        this.isInteractive = isInteractive;
        this.tag = tag;
        this.isOutdoor = isOutdoor;
        this.speaker_type = speaker_type;
        this.lighting_type = lighting_type;
        this.isDoorDeco = isDoorDeco;
        this.isCatalog = isCatalog;
        this.file_name = file_name;
        this.variant_id = variant_id;
        this.internal_id = internal_id;
        this.name = name;
        this.buy_price = buy_price;
        this.sell_price = sell_price;
        this.image_uri = image_uri;
    }

    public int getAppID() {
        return appID;
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

    public String getIsDiy() {
        return isDiy;
    }

    public String getCanCustomizeBody() {
        return canCustomizeBody;
    }

    public String getCanCustomizePattern() {
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

    public String getVersion() {
        return version;
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

    public String getIsInteractive() {
        return isInteractive;
    }

    public String getTag() {
        return tag;
    }

    public String getIsOutdoor() {
        return isOutdoor;
    }

    public String getSpeaker_type() {
        return speaker_type;
    }

    public String getLighting_type() {
        return lighting_type;
    }

    public String getIsDoorDeco() {
        return isDoorDeco;
    }

    public String getIsCatalog() {
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

    public String getName() {
        return name;
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
}
