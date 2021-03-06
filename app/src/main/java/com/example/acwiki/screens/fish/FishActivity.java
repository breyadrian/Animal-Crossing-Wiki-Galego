package com.example.acwiki.screens.fish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;

import com.example.acwiki.AdminSQLiteOpenHelper;
import com.example.acwiki.R;

import java.util.ArrayList;

public class FishActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    SearchView txtBuscar;
    AdminSQLiteOpenHelper conn;
    ArrayList<String> listarinfo;
    ArrayList<FishData> listarPeces;
    FishRecyclerViewAdapter adapter;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish);
        txtBuscar = findViewById(R.id.buscador);
        RecyclerView recyclerView = findViewById(R.id.fishRecyclerView);
        Activity activity =this;

        conn= new AdminSQLiteOpenHelper(getApplicationContext(),"administracion",null,1);

        ArrayList<FishData> data= consultar();
        adapter = new FishRecyclerViewAdapter(data, activity);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity.getApplicationContext()));


        txtBuscar.setOnQueryTextListener(this);
    }




    private ArrayList<FishData> consultar(){
        SQLiteDatabase db=conn.getReadableDatabase();

        FishData fishData = null;
        listarPeces= new ArrayList<FishData>();
        Cursor cursor = db.rawQuery("SELECT * FROM Fish",null);

        if(cursor.moveToFirst()){
            do{
                listarPeces.add(new FishData(cursor.getInt(0),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5),cursor.getInt(6),cursor.getString(7),cursor.getString(8),cursor.getBlob(9),cursor.getBlob(10)));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return listarPeces;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapter.filtrado(s);
        return false;
    }
}