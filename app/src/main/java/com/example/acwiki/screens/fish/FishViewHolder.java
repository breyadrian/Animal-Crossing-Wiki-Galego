package com.example.acwiki.screens.fish;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acwiki.R;
import com.squareup.picasso.Picasso;

public class FishViewHolder extends RecyclerView.ViewHolder {

    private final TextView id;
    private final TextView fishName;


  //  private final ImageView image_uri;
    private final ImageView icon_uri;
    private final CardView cardView;


    public FishViewHolder(@NonNull View itemView) {
        super(itemView);
        this.cardView= (CardView) itemView.findViewById(R.id.user_walks_cardView);
        this.id = (TextView) itemView.findViewById(R.id.id);
        this.fishName = (TextView) itemView.findViewById(R.id.fishName);

       // this.image_uri = (ImageView) itemView.findViewById(R.id.image_uri);
        this.icon_uri = (ImageView) itemView.findViewById(R.id.icon_uri);
    }
    public void showData(FishData data, Activity activity) {


      //  Picasso.get().load(data.getImage_uri()).into(image_uri);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, DetailFishActivity.class);
                intent.putExtra("nombre", data.getName());
                intent.putExtra("imagen", data.getImage_uri());
                intent.putExtra("id",data.getId());
                intent.putExtra("price",data.getPrecio());
                intent.putExtra("price_cj",data.getPrecio_cj());
                intent.putExtra("avalavility",data.getAbaliability());
                intent.putExtra("shadow",data.getShadow());

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
        fishName.setText("Nome: " + str);

        id.setText("Id: "+ data.getId());


    }

}
