package com.example.acwiki.screens.fish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;

import com.example.acwiki.AdminSQLiteOpenHelper;
import com.example.acwiki.R;
import com.example.acwiki.client.DTOs.FishDTO;
import com.example.acwiki.client.RestClient;
import com.example.acwiki.client.handlers.GetFishHandler;

import java.util.ArrayList;
import java.util.List;

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





    /*
        RestClient.getInstance(this).getFish(this, new GetFishHandler() {
            @Override
            public void requestDidFail(int statusCode) {
                System.out.println("la peticion falló");
                System.out.println(statusCode);
            }

            @Override
            public void requestComplete(List<FishDTO> dto, Activity activity) {
                for (FishDTO dtoItem : dto) {
                    data.add(new FishData(dtoItem.getId(), dtoItem.getName().getNameEUes(), dtoItem.getImage_uri(), dtoItem.getIcon_uri()));
                }
                FishRecyclerViewAdapter adapter = new FishRecyclerViewAdapter(data, activity);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(activity.getApplicationContext()));
            }
        });*/


        txtBuscar.setOnQueryTextListener(this);
    }


    private ArrayList<FishData> consultar(){
        SQLiteDatabase db=conn.getReadableDatabase();

        FishData fishData = null;
        listarPeces= new ArrayList<FishData>();
        Cursor cursor = db.rawQuery("SELECT * FROM Fish",null);

        if(cursor.moveToFirst()){
            do{
                listarPeces.add(new FishData(cursor.getInt(0),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5),cursor.getInt(6),cursor.getBlob(9),cursor.getBlob(10)));
            }while(cursor.moveToNext());
        }
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