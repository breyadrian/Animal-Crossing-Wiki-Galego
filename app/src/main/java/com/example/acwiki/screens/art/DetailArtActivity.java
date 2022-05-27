package com.example.acwiki.screens.art;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acwiki.R;
import com.example.acwiki.screens.bugs.BugsData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DetailArtActivity extends AppCompatActivity {

    private String fraseMuseo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_art);

        ArtData data = getIntent().getParcelableExtra("data");
        String nome =getIntent().getStringExtra("name");
        Bitmap bm= BitmapFactory.decodeByteArray(data.getImage_uri(), 0 ,data.getImage_uri().length);

        TextView pieceName = findViewById(R.id.pieceName);
        pieceName.setText(primeraMayuscula(nome));

        ImageView bugImagen =  findViewById(R.id.pieceImage);
        bugImagen.setImageBitmap(bm);

        TextView hasFake = findViewById(R.id.hasFake);
        hasFake.setText("Ten falso: "+data.isHasFake());

        TextView buy_price = findViewById(R.id.buy_price);
        buy_price.setText("Precio compra: "+data.getBuy_price());

        TextView sell_price = findViewById(R.id.sell_price);
        sell_price.setText("Precio venta: "+data.getSell_price());

        TextView museum_desc = findViewById(R.id.museum_desc);
        museum_desc.setText(primeraMayuscula(data.getMuseum_desc()));


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