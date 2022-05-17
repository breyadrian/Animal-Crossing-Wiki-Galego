package com.example.acwiki.screens.items;

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

public class DetailItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);


        String appID = getIntent().getStringExtra("appID");
        String variant = getIntent().getStringExtra("variant");
        String body_title = getIntent().getStringExtra("body_title");
        String pattern = getIntent().getStringExtra("pattern");
        String pattern_title = getIntent().getStringExtra("pattern_title");
        String isDiy = getIntent().getStringExtra("isDiy");
        String canCustomizeBody = getIntent().getStringExtra("canCustomizeBody");
        String canCustomizePattern = getIntent().getStringExtra("canCustomizePattern");
        int kit_cost = getIntent().getIntExtra("kit_cost",0);
        String color1 = getIntent().getStringExtra("color1");
        String color2 = getIntent().getStringExtra("color2");
        String size = getIntent().getStringExtra("size");
        String source_detail = getIntent().getStringExtra("source_detail");
        String version = getIntent().getStringExtra("version");
        String hha_concept_1 = getIntent().getStringExtra("hha_concept_1");
        String hha_concept_2 = getIntent().getStringExtra("hha_concept_2");
        String hha_series = getIntent().getStringExtra("hha_series");
        String hha_set = getIntent().getStringExtra("hha_set");
        String isInteractive = getIntent().getStringExtra("isInteractive");
        String tag = getIntent().getStringExtra("tag");
        String isOutdoor = getIntent().getStringExtra("isOutdoor");
        String speaker_type = getIntent().getStringExtra("speaker_type");
        String lighting_type = getIntent().getStringExtra("lighting_type");
        String isDoorDeco = getIntent().getStringExtra("isDoorDeco");
        String isCatalog = getIntent().getStringExtra("isCatalog");
        String file_name = getIntent().getStringExtra("file_name");
        String variant_id = getIntent().getStringExtra("variant_id");
        int internal_id = getIntent().getIntExtra("internal_id",0);
        String name = getIntent().getStringExtra("name");
        int buy_price = getIntent().getIntExtra("buy_price",0);
        int sell_price = getIntent().getIntExtra("sell_price",0);
        byte[] image = getIntent().getByteArrayExtra("image_uri");







        Bitmap bm= BitmapFactory.decodeByteArray(image, 0 ,image.length);



        TextView meses = findViewById(R.id.villagerGender);
//        meses.setText("Meses norte: "+mesesNorte);
        TextView horasFish = findViewById(R.id.CreatureHoras);
   //     horasFish.setText("Horario: "+horario);
        TextView rarezaFish = findViewById(R.id.villagerCatch_phrase);
  //      rarezaFish.setText("Rareza: "+primeraMayuscula(rareza));
        TextView fishLocation = findViewById(R.id.localizacion);
   //     fishLocation.setText("Ubicación: "+primeraMayuscula(ubicacion));



        TextView fishName = findViewById(R.id.creatureName);
     //   fishName.setText("Nome: "+primeraMayuscula(nombre));

        TextView fishPrice = findViewById(R.id.precioCriatura);
    //    fishPrice.setText("Prezo: "+price);

        TextView fishPrice_cj = findViewById(R.id.speed);
   //     fishPrice_cj.setText("Prezo con CJ: "+price_cj);


        TextView fishShadow = findViewById(R.id.CreatureShadow);
     //   fishShadow.setText("Sombra: "+getShadow(shadow));

        ImageView fishImagen =  findViewById(R.id.creatureImage);
        fishImagen.setImageBitmap(bm);

        TextView fishId = findViewById(R.id.creatureId);
//        fishId.setText("Identificador: "+id);

       // System.out.println(availability);
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