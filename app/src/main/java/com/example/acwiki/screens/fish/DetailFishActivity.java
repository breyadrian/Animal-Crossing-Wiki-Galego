package com.example.acwiki.screens.fish;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acwiki.R;

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
        String shadow = getIntent().getStringExtra("shadow");

        Bitmap bm= BitmapFactory.decodeByteArray(image, 0 ,image.length);

        System.out.println(price);


        String str = nombre;
        String firstLtr = str.substring(0, 1);
        String restLtrs = str.substring(1, str.length());
        firstLtr = firstLtr.toUpperCase();
        str = firstLtr + restLtrs;
        TextView fishName = findViewById(R.id.fishName);
        fishName.setText("Nome: "+str);

        TextView fishPrice = findViewById(R.id.fishPrice);
        fishPrice.setText("Prezo: "+price);

        TextView fishPrice_cj = findViewById(R.id.fishPrice_cj);
        fishPrice_cj.setText("Prezo con CJ: "+price_cj);


        TextView fishShadow = findViewById(R.id.fishShadow);
        fishShadow.setText("Sombra: "+getShadow(shadow));

        ImageView fishImagen =  findViewById(R.id.fishImage);
        fishImagen.setImageBitmap(bm);

        TextView fishId = findViewById(R.id.fishId);
        fishId.setText("Identificador: "+id);


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
                shadow="Media-grnade con aleta";
                break;
            case ("Large (5)"):
                shadow="Grande";
                break;
            case ("Largest (6)"):
                shadow="A máis grande";
                break;
            case ("Largest with fin (6)"):
                shadow="A máis grnade con aleta";
                break;
            case ("Narrow"):
                shadow="Estreita";
                break;
        }

        return shadow;
    }
}