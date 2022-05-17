package com.example.acwiki.screens.fossils;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acwiki.R;

public class DetailFossilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_fossil);

        String nombre = getIntent().getStringExtra("nombre");
        byte[] image = getIntent().getByteArrayExtra("imagen");
        int price = getIntent().getIntExtra("price",0);
        int fraseMuseo = getIntent().getIntExtra("museum_phrase",0);
        String part= getIntent().getStringExtra("part_of");


        Bitmap bm= BitmapFactory.decodeByteArray(image, 0 ,image.length);


        TextView fossilPrice = findViewById(R.id.fossilPrice);
        fossilPrice.setText("Prezo: "+price);

        TextView fossilName = findViewById(R.id.fossilName);
        fossilName.setText("Nome: "+primeraMayuscula(nombre));


        TextView fossilPart = findViewById(R.id.fossilPart);
        fossilPart.setText("Parte: "+primeraMayuscula(part));

        ImageView fossilImagen =  findViewById(R.id.fossilIcon);
        fossilImagen.setImageBitmap(bm);

        TextView museumPhrase = findViewById(R.id.museum_phrase);
        museumPhrase.setText("Frase do museo: "+fraseMuseo);



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