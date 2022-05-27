package com.example.acwiki.screens.fossils.partes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acwiki.R;
import com.example.acwiki.screens.fossils.DetailFossilActivity;
import com.example.acwiki.screens.fossils.FossilData;
import com.example.acwiki.screens.items.ItemData;

public class FossilPartViewHolder extends RecyclerView.ViewHolder {


    private final TextView parte;
    private final TextView fossilName;
    private final CardView cardView;


    public FossilPartViewHolder(@NonNull View itemView) {
        super(itemView);
        this.cardView= (CardView) itemView.findViewById(R.id.fossilCardView);
        this.parte = (TextView) itemView.findViewById(R.id.id);
        this.fossilName = (TextView) itemView.findViewById(R.id.fossilName);



    }
    public void showData(FossilData data) {



        String str = data.getName();
        String firstLtr = str.substring(0, 1);
        String restLtrs = str.substring(1, str.length());

        firstLtr = firstLtr.toUpperCase();
        str = firstLtr + restLtrs;
        fossilName.setText("Nome: " + str);

        parte.setText("Parte de: "+ data.getPart_of());


    }


}
