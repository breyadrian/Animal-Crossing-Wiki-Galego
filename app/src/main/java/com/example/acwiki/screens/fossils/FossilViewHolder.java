package com.example.acwiki.screens.fossils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acwiki.R;

public class FossilViewHolder extends RecyclerView.ViewHolder {

    private final TextView parte;
    private final TextView fossilName;
    private final CardView cardView;


    public FossilViewHolder(@NonNull View itemView) {
        super(itemView);
        this.cardView= (CardView) itemView.findViewById(R.id.fossilCardView);
        this.parte = (TextView) itemView.findViewById(R.id.id);
        this.fossilName = (TextView) itemView.findViewById(R.id.fossilName);

        // this.image_uri = (ImageView) itemView.findViewById(R.id.image_uri);

    }
    public void showData(FossilData data, Activity activity) {


        //  Picasso.get().load(data.getImage_uri()).into(image_uri);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, DetailFossilActivity.class);
                intent.putExtra("nombre", data.getName());
                intent.putExtra("imagen", data.getImage_uri());
                intent.putExtra("price",data.getPrice());
                intent.putExtra("museum_phrase",data.getMuseum_phrase());
                intent.putExtra("part_of",data.getPart_of());


                activity.startActivity(intent);
            }
        });



        String str = data.getName();
        String firstLtr = str.substring(0, 1);
        String restLtrs = str.substring(1, str.length());

        firstLtr = firstLtr.toUpperCase();
        str = firstLtr + restLtrs;
        fossilName.setText("Nome: " + str);

        parte.setText("Parte de: "+ data.getPart_of());


    }



}
