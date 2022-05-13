package com.example.acwiki.screens.bugs;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acwiki.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DetailBugActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_bug);

        String nombre = getIntent().getStringExtra("nombre");
        byte[] image = getIntent().getByteArrayExtra("imagen");
        int id = getIntent().getIntExtra("id",0);
        int price = getIntent().getIntExtra("price",0);
        int price_flick = getIntent().getIntExtra("price_flick",0);
        String availability= getIntent().getStringExtra("availability");
        String shadow = getIntent().getStringExtra("shadow");

        Bitmap bm= BitmapFactory.decodeByteArray(image, 0 ,image.length);

        System.out.println(price);


        String mesesNorte = null;
        String horario = null;
        String ubicacion = null;
        String rareza = null;
        try {
            JSONObject jsonObject = new JSONObject(availability);
            System.out.println("OBJECT : "+jsonObject.toString());

            mesesNorte = jsonObject.getString("month-northern");
            String mesesSur = jsonObject.getString("month-southern");
            horario =  jsonObject.getString("time");
            boolean isAllDay = jsonObject.getBoolean("isAllDay");
            boolean isAllYear = jsonObject.getBoolean("isAllYear");
            ubicacion = jsonObject.getString("location");
            rareza = jsonObject.getString("rarity");
            JSONArray mesesArrayNorte = jsonObject.getJSONArray("month-array-northern");
            JSONArray mesesArraySur = jsonObject.getJSONArray("month-array-southern");
            JSONArray horasArray = jsonObject.getJSONArray("time-array");

        } catch (JSONException e) {
            e.printStackTrace();
        }



        if(mesesNorte.length()<1){
        mesesNorte= "Todo o ano";
    }
        if(horario.length()<1){
        horario="Todo o día";
    }

    TextView meses = findViewById(R.id.villagerGender);
            meses.setText("Meses norte: "+mesesNorte);
    TextView horasbug = findViewById(R.id.CreatureHoras);
            horasbug.setText("Horario: "+horario);
    TextView rarezaBug = findViewById(R.id.villagerCatch_phrase);
            rarezaBug.setText("Rareza: "+primeraMayuscula(rareza));
    TextView bugLocation = findViewById(R.id.localizacion);
            bugLocation.setText("Ubicación: "+primeraMayuscula(ubicacion));



    TextView bugName = findViewById(R.id.creatureName);
        bugName.setText("Nome: "+primeraMayuscula(nombre));

    TextView bugPrice = findViewById(R.id.precioCriatura);
        bugPrice.setText("Prezo: "+price);

    TextView bugPrice_cj = findViewById(R.id.speed);
        bugPrice_cj.setText("Prezo con Flick: "+price_flick);


    ImageView bugImagen =  findViewById(R.id.creatureImage);
        bugImagen.setImageBitmap(bm);

    TextView bugId = findViewById(R.id.creatureId);
        bugId.setText("Identificador: "+id);

        System.out.println(availability);
}



    public String primeraMayuscula(String palabra){
        String str = palabra;
        String firstLtr = str.substring(0, 1);
        String restLtrs = str.substring(1, str.length());
        firstLtr = firstLtr.toUpperCase();
        str = firstLtr + restLtrs;

        return str;
    }



}