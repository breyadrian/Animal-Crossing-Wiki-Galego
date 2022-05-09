package com.example.acwiki;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{


    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {

        BaseDeDatos.execSQL("create table Fish(id int primary key, file_name String, name String, availabiliti String, shadow String, price int, price_cj int, catch_phrase String, museum_phrase String, image BLOB, icon BLOB) ");
        BaseDeDatos.execSQL(" PRAGMA page_size = 4096;");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
