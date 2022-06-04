package com.example.acwiki.screens.villagers.espceies;

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
import com.example.acwiki.screens.items.ItemData;
import com.example.acwiki.screens.villagers.DetailVillagerActivity;
import com.example.acwiki.screens.villagers.VillagerData;

public class EspeciesViewHolder extends RecyclerView.ViewHolder {

    private final TextView id;
    private final TextView villagerName;


    //  private final ImageView image_uri;
    private final ImageView icon_uri;
    private final CardView cardView;

    public EspeciesViewHolder(@NonNull View itemView) {
        super(itemView);
        this.cardView= (CardView) itemView.findViewById(R.id.villagerCardView);
        this.id = (TextView) itemView.findViewById(R.id.id);
        this.villagerName = (TextView) itemView.findViewById(R.id.villagerName);

        // this.image_uri = (ImageView) itemView.findViewById(R.id.image_uri);
        this.icon_uri = (ImageView) itemView.findViewById(R.id.icon_uri);
    }
    public void showData(VillagerData data, Activity activity) {
        Bitmap bm= BitmapFactory.decodeByteArray(data.getIcon_uri(), 0 ,data.getIcon_uri().length);
        icon_uri.setImageBitmap(bm);


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, DetailVillagerActivity.class);
                intent.putExtra("data", data);


                activity.startActivity(intent);
            }
        });

        String str = data.getName();
        String firstLtr = str.substring(0, 1);
        String restLtrs = str.substring(1, str.length());

        firstLtr = firstLtr.toUpperCase();
        str = firstLtr + restLtrs;
        villagerName.setText("Nome: " + str);

        id.setText("Id: "+ data.getId());


    }

}