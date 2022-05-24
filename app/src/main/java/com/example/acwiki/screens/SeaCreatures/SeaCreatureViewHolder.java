package com.example.acwiki.screens.SeaCreatures;

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

public class SeaCreatureViewHolder extends RecyclerView.ViewHolder {

    private final TextView id;
    private final TextView creatureName;


  //  private final ImageView image_uri;
    private final ImageView icon_uri;
    private final CardView cardView;


    public SeaCreatureViewHolder(@NonNull View itemView) {
        super(itemView);
        this.cardView= (CardView) itemView.findViewById(R.id.seaCreatureCardView);
        this.id = (TextView) itemView.findViewById(R.id.id);
        this.creatureName = (TextView) itemView.findViewById(R.id.creatureName);

       // this.image_uri = (ImageView) itemView.findViewById(R.id.image_uri);
        this.icon_uri = (ImageView) itemView.findViewById(R.id.icon_uri);
    }
    public void showData(SeaCreatureData data, Activity activity) {


      //  Picasso.get().load(data.getImage_uri()).into(image_uri);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, DetailSeaCreatureActivity.class);
                intent.putExtra("data", data);

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
        creatureName.setText("Nome: " + str);

        id.setText("Id: "+ data.getId());


    }

}
