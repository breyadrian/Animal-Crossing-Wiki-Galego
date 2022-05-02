package com.example.acwiki.DTOs;

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
    private String Color1;
    private String Color2;
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
    private boolean isCatalog;
    private String file_name;
    private String variant_id;
    private int internal_id;
    private ArrayList name;
    private int buy_price;
    private int sell_price;
    private String image_uri;


    public ItemDTO(String variant, String body_title, String pattern, String pattern_title, boolean isDiy, boolean canCustomizeBody, boolean canCustomizePattern, int kit_cost, String color1, String color2, String size, String source, String source_detail, String versio, String hha_concept_1, String hha_concept_2, String hha_series, String hha_set, boolean isInteractive, String tag, boolean isOutdoor, String speaker_type, String lighting_type, boolean isCatalog, String file_name, String variant_id, int internal_id, ArrayList name, int buy_price, int sell_price, String image_uri) {
        this.variant = variant;
        this.body_title = body_title;
        this.pattern = pattern;
        this.pattern_title = pattern_title;
        this.isDiy = isDiy;
        this.canCustomizeBody = canCustomizeBody;
        this.canCustomizePattern = canCustomizePattern;
        this.kit_cost = kit_cost;
        Color1 = color1;
        Color2 = color2;
        this.size = size;
        this.source = source;
        this.source_detail = source_detail;
        this.versio = versio;
        this.hha_concept_1 = hha_concept_1;
        this.hha_concept_2 = hha_concept_2;
        this.hha_series = hha_series;
        this.hha_set = hha_set;
        this.isInteractive = isInteractive;
        this.tag = tag;
        this.isOutdoor = isOutdoor;
        this.speaker_type = speaker_type;
        this.lighting_type = lighting_type;
        this.isCatalog = isCatalog;
        this.file_name = file_name;
        this.variant_id = variant_id;
        this.internal_id = internal_id;
        this.name = name;
        this.buy_price = buy_price;
        this.sell_price = sell_price;
        this.image_uri = image_uri;
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
        return Color1;
    }

    public String getColor2() {
        return Color2;
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

    public ArrayList getName() {
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