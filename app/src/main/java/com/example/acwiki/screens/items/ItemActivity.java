package com.example.acwiki.screens.items;

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

public class ItemActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    SearchView txtBuscar;
    AdminSQLiteOpenHelper conn;
    ArrayList<String> listarinfo;
    ArrayList<ItemData> listarItem;
    ItemRecyclerViewAdapter adapter;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        txtBuscar = findViewById(R.id.buscador);
        RecyclerView recyclerView = findViewById(R.id.itemRecyclerView);
        Activity activity =this;

        conn= new AdminSQLiteOpenHelper(getApplicationContext(),"administracion",null,1);

        ArrayList<ItemData> data= consultar();
        adapter = new ItemRecyclerViewAdapter(data, activity);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity.getApplicationContext()));

        txtBuscar.setOnQueryTextListener(this);
    }


    private ArrayList<ItemData> consultar(){
        SQLiteDatabase db=conn.getReadableDatabase();
        int anterior=0;
        ItemData itemData = null;
        listarItem= new ArrayList<ItemData>();
        Cursor cursor = db.rawQuery("SELECT * FROM Items ORDER BY internal_id",null);

        if(cursor.moveToFirst()){
            do{
                if(cursor.getInt(28)!=anterior) {
                    listarItem.add(new ItemData(
                            cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                            cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getInt(8), cursor.getString(9),
                            cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14),
                            cursor.getString(15), cursor.getString(16), cursor.getString(17), cursor.getString(18), cursor.getString(19),
                            cursor.getString(20), cursor.getString(21), cursor.getString(22), cursor.getString(23), cursor.getString(24),
                            cursor.getString(25), cursor.getString(26), cursor.getString(27), cursor.getInt(28), cursor.getString(29),
                            cursor.getInt(30), cursor.getInt(31), cursor.getBlob(32)));

                }
                anterior=cursor.getInt(28);
            }while(cursor.moveToNext());
        }




        return listarItem;
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