package com.example.acwiki.screens.art;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.acwiki.AdminSQLiteOpenHelper;
import com.example.acwiki.R;


import java.util.ArrayList;

public class ArtActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    SearchView txtBuscar;
    AdminSQLiteOpenHelper conn;
    ArrayList<ArtData> listarArte;
    ArtRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art);

        txtBuscar = findViewById(R.id.buscador);
        RecyclerView recyclerView = findViewById(R.id.artRecyclerView);
        Activity activity =this;

        conn= new AdminSQLiteOpenHelper(getApplicationContext(),"administracion",null,1);

        ArrayList<ArtData> data= consultar();
        adapter = new ArtRecyclerViewAdapter(data, activity);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity.getApplicationContext()));

        txtBuscar.setOnQueryTextListener(this);
    }
    private ArrayList<ArtData> consultar(){
        SQLiteDatabase db=conn.getReadableDatabase();


        listarArte= new ArrayList<ArtData>();
        Cursor cursor = db.rawQuery("SELECT * FROM Arte",null);

        if(cursor.moveToFirst()){
            do{
                listarArte.add(new ArtData(cursor.getInt(0),cursor.getString(2),cursor.getString(3),cursor.getInt(4),cursor.getInt(5),cursor.getBlob(7),cursor.getString(6)));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return listarArte;
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