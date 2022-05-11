package com.example.acwiki.screens.bugs;

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
import com.example.acwiki.screens.fish.FishData;
import com.example.acwiki.screens.fish.FishRecyclerViewAdapter;

import java.util.ArrayList;

public class BugsActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    SearchView txtBuscar;
    AdminSQLiteOpenHelper conn;
    ArrayList<String> listarinfo;
    ArrayList<BugsData> listarBichos;
    BugsRecyclerViewAdapter adapter;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bugs);


        txtBuscar = findViewById(R.id.buscador);
        RecyclerView recyclerView = findViewById(R.id.bugsRecyclerView);
        Activity activity =this;

        conn= new AdminSQLiteOpenHelper(getApplicationContext(),"administracion",null,1);

        ArrayList<BugsData> data= consultar();
        adapter = new BugsRecyclerViewAdapter(data, activity);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity.getApplicationContext()));


        txtBuscar.setOnQueryTextListener(this);

    }

    private ArrayList<BugsData> consultar(){
        SQLiteDatabase db=conn.getReadableDatabase();

        BugsData bugsData = null;
        listarBichos = new ArrayList<BugsData>();
        Cursor cursor = db.rawQuery("SELECT * FROM Bugs",null);

        if(cursor.moveToFirst()){
            do{
                listarBichos.add(new BugsData(cursor.getInt(0),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5),cursor.getInt(6),cursor.getBlob(9),cursor.getBlob(10)));
            }while(cursor.moveToNext());
        }
        return listarBichos;
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