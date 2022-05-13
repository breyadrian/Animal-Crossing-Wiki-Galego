package com.example.acwiki.screens.fossils;

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

public class FossilActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    SearchView txtBuscar;
    AdminSQLiteOpenHelper conn;
    ArrayList<String> listarinfo;
    ArrayList<FossilData> listarFosiles;
    FossilRecyclerViewAdapter adapter;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fossil);
        txtBuscar = findViewById(R.id.buscador);
        RecyclerView recyclerView = findViewById(R.id.fossilRecyclerView);
        Activity activity =this;

        conn= new AdminSQLiteOpenHelper(getApplicationContext(),"administracion",null,1);

        ArrayList<FossilData> data= consultar();
        adapter = new FossilRecyclerViewAdapter(data, activity);

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


    private ArrayList<FossilData> consultar(){
        SQLiteDatabase db=conn.getReadableDatabase();

        FossilData fossilData = null;
        listarFosiles= new ArrayList<FossilData>();
        Cursor cursor = db.rawQuery("SELECT * FROM Fossils",null);

        if(cursor.moveToFirst()){
            do{
                listarFosiles.add(new FossilData(cursor.getString(1),cursor.getInt(2),cursor.getString(3),cursor.getBlob(4),cursor.getString(5)));
            }while(cursor.moveToNext());
        }
        return listarFosiles;
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