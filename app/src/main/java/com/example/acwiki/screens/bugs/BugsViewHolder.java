package com.example.acwiki.screens.bugs;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acwiki.R;

public class BugsViewHolder extends RecyclerView.ViewHolder {

    private final TextView id;
    private final TextView bugName;


    //  private final ImageView image_uri;
    private final ImageView icon_uri;
    private final CardView cardView;


    public BugsViewHolder(@NonNull View itemView) {
        super(itemView);
        this.cardView= (CardView) itemView.findViewById(R.id.villagerCardView);
        this.id = (TextView) itemView.findViewById(R.id.id);
        this.bugName = (TextView) itemView.findViewById(R.id.villagerName);

        // this.image_uri = (ImageView) itemView.findViewById(R.id.image_uri);
        this.icon_uri = (ImageView) itemView.findViewById(R.id.icon_uri);
    }
    public void showData(BugsData data, Activity activity) {


        //  Picasso.get().load(data.getImage_uri()).into(image_uri);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, DetailBugActivity.class);
                intent.putExtra("nombre", data.getName());
                intent.putExtra("imagen", data.getImage_uri());
                intent.putExtra("id",data.getId());
                intent.putExtra("price",data.getPrecio());
                intent.putExtra("price_flick",data.getPrecio_flick());
                intent.putExtra("availability",data.getAvailability());


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
        bugName.setText("Nome: " + str);

        id.setText("Id: "+ data.getId());


    }
}