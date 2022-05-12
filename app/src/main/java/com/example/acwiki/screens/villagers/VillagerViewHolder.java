package com.example.acwiki.screens.villagers;

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


public class VillagerViewHolder extends RecyclerView.ViewHolder {

    private final TextView id;
    private final TextView villagerName;


    //  private final ImageView image_uri;
    private final ImageView icon_uri;
    private final CardView cardView;

    public VillagerViewHolder(@NonNull View itemView) {
        super(itemView);
        this.cardView= (CardView) itemView.findViewById(R.id.villagerCardView);
        this.id = (TextView) itemView.findViewById(R.id.id);
        this.villagerName = (TextView) itemView.findViewById(R.id.villagerName);

        // this.image_uri = (ImageView) itemView.findViewById(R.id.image_uri);
        this.icon_uri = (ImageView) itemView.findViewById(R.id.icon_uri);
    }
    public void showData(VillagerData data, Activity activity) {


        //  Picasso.get().load(data.getImage_uri()).into(image_uri);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, DetailVillagerActivity.class);
                intent.putExtra("nombre", data.getName());
                intent.putExtra("imagen", data.getImage_uri());
                intent.putExtra("id",data.getId());
                intent.putExtra("birthday",data.getBirthday());
                intent.putExtra("birthday_string",data.getBirthday_string());
                intent.putExtra("personality",data.getPersonality());
                intent.putExtra("gender",data.getGender());
                intent.putExtra("species",data.getSpecies());
                intent.putExtra("catch_phrase",data.getCatch_phrase());

                activity.startActivity(intent);
            }
        });
        Bitmap bm= BitmapFactory.decodeByteArray(data.getIcon_uri(), 0 ,data.getIcon_uri().length);
        icon_uri.setImageBitmap(bm);

        String str = data.getName();
        String firstLtr = str.substring(0, 1);
        String restLtrs = str.substring(1, str.length());

        firstLtr = firstLtr.toUpperCase();
        str = firstLtr + restLtrs;
        villagerName.setText("Nome: " + str);

        id.setText("Id: "+ data.getId());


    }


}
