package com.example.acwiki.screens.villagers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acwiki.AdminSQLiteOpenHelper;
import com.example.acwiki.R;
import com.example.acwiki.screens.villagers.espceies.EspeciesRecyclerViewAdapter;

import java.util.ArrayList;

public class DetailVillagerActivity extends AppCompatActivity {
    AdminSQLiteOpenHelper conn;
    ArrayList<String> listarinfo;
    ArrayList<VillagerData> listarVillagers;
    EspeciesRecyclerViewAdapter adapter;
    VillagerData dataVillager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_villager);


        RecyclerView recyclerView = findViewById(R.id.especiesRecyclerView);

        conn= new AdminSQLiteOpenHelper(getApplicationContext(),"administracion",null,1);
        dataVillager = getIntent().getParcelableExtra("data");
        ArrayList<VillagerData> data = consultar();
        adapter = new EspeciesRecyclerViewAdapter(data, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));






        Bitmap bm = BitmapFactory.decodeByteArray(dataVillager.getImage_uri(), 0, dataVillager.getImage_uri().length);

        TextView genderTxt = findViewById(R.id.villagerGender);
        genderTxt.setText("Xénero: " + getGender(dataVillager.getGender()));

        TextView speciesTxt = findViewById(R.id.species);
        speciesTxt.setText("Especie: " + dataVillager.getSpecies());

        TextView catch_phraseTxt = findViewById(R.id.villagerCatch_phrase);
        catch_phraseTxt.setText("Frase de captura: " + primeraMayuscula(dataVillager.getCatch_phrase()));

        TextView villagerName = findViewById(R.id.VillagerName);
        villagerName.setText("Nome: " + primeraMayuscula(dataVillager.getName()));

        TextView birthdayTxt = findViewById(R.id.birthday);
        birthdayTxt.setText("Cumpleanos: " + dataVillager.getBirthday());

        TextView personalityTxt = findViewById(R.id.personality);
        personalityTxt.setText("Personalidade: " + getPersonality(dataVillager.getPersonality()));


        ImageView villagerImage = findViewById(R.id.creatureImage);
        villagerImage.setImageBitmap(bm);

        TextView villagerId = findViewById(R.id.creatureId);
        villagerId.setText("Identificador: " + dataVillager.getId());


    }

    private ArrayList<VillagerData> consultar(){
        SQLiteDatabase db=conn.getReadableDatabase();

        VillagerData villagerdata = null;
        listarVillagers = new ArrayList<VillagerData>();
        Cursor cursor = db.rawQuery("SELECT * FROM Villagers where species='"+dataVillager.getSpecies()+"'",null);

        if(cursor.moveToFirst()){
            do{
                listarVillagers.add(new VillagerData(cursor.getInt(0),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8),cursor.getBlob(9),cursor.getBlob(10)));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return listarVillagers;
    }


    public String primeraMayuscula(String palabra) {
        String str = palabra;
        String firstLtr = str.substring(0, 1);
        String restLtrs = str.substring(1, str.length());
        firstLtr = firstLtr.toUpperCase();
        str = firstLtr + restLtrs;

        return str;
    }

    public String getGender(String gender){
        switch (gender) {
            case ("Female"):
                gender = "Femenino";
                break;
            case ("Male"):
                gender = "Masculino";
                break;
        }
        return gender;
    }

    public String getPersonality (String personality){

        switch (personality){
            case ("Jock"):
                personality="Atlético";
                break;
            case ("Uchi"):
                personality="Doce";
                break;
            case ("Cranky"):
                personality="Malhumorado";
                break;
            case ("Normal"):
                personality="Normal";
                break;
            case ("Lazy"):
                personality="Preguiceiro";
                break;
            case ("Peppy"):
                personality="Alegre";
                break;
            case ("Smug"):
                personality="Esnob";
                break;
            case ("Snooty"):
                personality="Presumida";
                break;

        }

        return personality;
    }

}