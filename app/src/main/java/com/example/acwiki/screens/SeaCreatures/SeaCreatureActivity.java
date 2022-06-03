package com.example.acwiki.screens.SeaCreatures;

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

public class SeaCreatureActivity extends AppCompatActivity  implements SearchView.OnQueryTextListener {
    SearchView txtBuscar;
    AdminSQLiteOpenHelper conn;
    ArrayList<String> listarinfo;
    ArrayList<SeaCreatureData> listarCriaturas;
    SeaCreatureRecyclerViewAdapter adapter;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sea_creature);
        txtBuscar = findViewById(R.id.buscador);
        RecyclerView recyclerView = findViewById(R.id.seaCreatureRecyclerView);
        Activity activity =this;

        conn= new AdminSQLiteOpenHelper(getApplicationContext(),"administracion",null,1);

        ArrayList<SeaCreatureData> data= consultar();
        adapter = new SeaCreatureRecyclerViewAdapter(data, activity);

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


    private ArrayList<SeaCreatureData> consultar(){
        SQLiteDatabase db=conn.getReadableDatabase();

        SeaCreatureData creaturesData = null;
        listarCriaturas = new ArrayList<SeaCreatureData>();
        Cursor cursor = db.rawQuery("SELECT * FROM SeaCreatures",null);

        if(cursor.moveToFirst()){
            do{
                listarCriaturas.add(new SeaCreatureData(cursor.getInt(0),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getInt(6),cursor.getString(7),cursor.getString(8),cursor.getBlob(9),cursor.getBlob(10)));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return listarCriaturas;
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