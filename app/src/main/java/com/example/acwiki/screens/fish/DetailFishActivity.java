package com.example.acwiki.screens.fish;

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

public class DetailFishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_fish);

        String nombre = getIntent().getStringExtra("nombre");
        byte[] image = getIntent().getByteArrayExtra("imagen");
        int id = getIntent().getIntExtra("id",0);
        int price = getIntent().getIntExtra("price",0);
        int price_cj = getIntent().getIntExtra("price_cj",0);
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

        System.out.println("holaas"+mesesNorte);
        if(mesesNorte.length()<1){
            mesesNorte= "Todo o ano";
        }
        if(horario.length()<1){
            horario="Todo o día";
        }

        TextView meses = findViewById(R.id.villagerGender);
            meses.setText("Meses norte: "+mesesNorte);
        TextView horasFish = findViewById(R.id.villagerSpecies);
            horasFish.setText("Horario: "+horario);
        TextView rarezaFish = findViewById(R.id.villagerCatch_phrase);
            rarezaFish.setText("Rareza: "+primeraMayuscula(rareza));
        TextView fishLocation = findViewById(R.id.localizacion);
            fishLocation.setText("Ubicación: "+primeraMayuscula(ubicacion));



        TextView fishName = findViewById(R.id.villagerName);
        fishName.setText("Nome: "+primeraMayuscula(nombre));

        TextView fishPrice = findViewById(R.id.birthday);
        fishPrice.setText("Prezo: "+price);

        TextView fishPrice_cj = findViewById(R.id.personality);
        fishPrice_cj.setText("Prezo con CJ: "+price_cj);


        TextView fishShadow = findViewById(R.id.fishShadow);
        fishShadow.setText("Sombra: "+getShadow(shadow));

        ImageView fishImagen =  findViewById(R.id.villagerImage);
        fishImagen.setImageBitmap(bm);

        TextView fishId = findViewById(R.id.villagerId);
        fishId.setText("Identificador: "+id);

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


    public String getShadow (String shadow){

        switch (shadow){
            case ("Smallest (1)"):
                shadow="A máis pequena";
                break;
            case ("Small (2)"):
                shadow="Pequena";
                break;
            case ("Medium (3)"):
                shadow="Media";
                break;
            case ("Medium (4)"):
                shadow="Media-grande";
                break;
            case (" Medium with fin (4)"):
                shadow="Media-grande con aleta";
                break;
            case ("Large (5)"):
                shadow="Grande";
                break;
            case ("Largest (6)"):
                shadow="A máis grande";
                break;
            case ("Largest with fin (6)"):
                shadow="A máis grande con aleta";
                break;
            case ("Narrow"):
                shadow="Estreita";
                break;
        }

        return shadow;
    }
}