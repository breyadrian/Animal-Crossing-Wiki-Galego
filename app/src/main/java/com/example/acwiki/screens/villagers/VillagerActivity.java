package com.example.acwiki.screens.villagers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.acwiki.AdminSQLiteOpenHelper;
import com.example.acwiki.R;

import java.util.ArrayList;

public class VillagerActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    SearchView txtBuscar;
    AdminSQLiteOpenHelper conn;
    ArrayList<String> listarinfo;
    ArrayList<VillagerData> listarVillagers;
    VillagerRecyclerViewAdapter adapter;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_villager);


        txtBuscar = findViewById(R.id.buscador);
        RecyclerView recyclerView = findViewById(R.id.seaCreatureRecyclerView);
        Activity activity =this;

        conn= new AdminSQLiteOpenHelper(getApplicationContext(),"administracion",null,1);

        ArrayList<VillagerData> data = consultar();
        adapter = new VillagerRecyclerViewAdapter(data, activity);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity.getApplicationContext()));


        txtBuscar.setOnQueryTextListener(this);
    }

    private ArrayList<VillagerData> consultar(){
        SQLiteDatabase db=conn.getReadableDatabase();

        VillagerData villagerdata = null;
        listarVillagers = new ArrayList<VillagerData>();
        Cursor cursor = db.rawQuery("SELECT * FROM Villagers",null);

        if(cursor.moveToFirst()){
            do{
                listarVillagers.add(new VillagerData(cursor.getInt(0),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8),cursor.getBlob(9),cursor.getBlob(10)));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return listarVillagers;
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