package com.example.acwiki;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

import com.example.acwiki.client.DTOs.NameDTO;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{


    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {

        BaseDeDatos.execSQL("create table Fish(id int primary key, file_name String, name String, availabiliti String, shadow String, price int, price_cj int, catch_phrase String, museum_phrase String, image BLOB, icon BLOB) ");
        BaseDeDatos.execSQL("create table Bugs(id int primary key, file_name String, name String, availabiliti String, shadow String, price int, price_flick int, catch_phrase String, museum_phrase String, image BLOB, icon BLOB) ");
        BaseDeDatos.execSQL("create table Villagers(id int primary key, file_name String, name String, personality String, birthday_string String, birthday String, species String, gender String, catch_phrase String,  image BLOB, icon BLOB) ");
        BaseDeDatos.execSQL("create table SeaCreatures(id int primary key, file_name String, name String, availabiliti String, speed String, shadow String, price int, catch_phrase String, museum_phrase String, image BLOB, icon BLOB) ");
        BaseDeDatos.execSQL("create table Fossils(file_name String primary key, name String, price int,museum_phrase String, image BLOB, part_of String) ");
        BaseDeDatos.execSQL("create table Items(id INTEGER primary key AUTOINCREMENT, variant String, body_title int, pattern String," +
                " pattern_title String, isDiy boolean, canCustomizeBody boolean, canCustomizePattern boolean, kit_cost int, color1 String, color2 String," +
                " size String, source String, source_detail String, version String, hha_concept_1 String, hha_concept_2 String, hha_series String, hha_set String," +
                " isInteractive boolean, tag String, isOutdoor boolean, speaker_type String, lighting_type String, isDoorDeco boolean, isCatalog boolean," +
                " file_name String, variant_id String, internal_id int, name String, buy_price int, sell_price int, image BLOB) ");
        BaseDeDatos.execSQL("create table Arte(id int primary key, file_name String, name String, hasFake boolean, buy_price int, sell_price int, museum_desc String, image BLOB) ");
        BaseDeDatos.execSQL("create table Musica(id int primary key, file_name String, hour int, wheather String, music_uri BLOB) ");
        BaseDeDatos.execSQL("create table Canciones(id int primary key, file_name String, name String, buy_price int, sell_price int, isOrderable boolean, music_uri BLOB, image_uri BLOB) ");




        BaseDeDatos.execSQL(" PRAGMA page_size = 4096;");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versionAntigua, int versionNueva) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Fish");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Bugs");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Villagers");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS SeaCreatures");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Fossils");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Items");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Arte");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Musica");
        onCreate(sqLiteDatabase);
    }
}
