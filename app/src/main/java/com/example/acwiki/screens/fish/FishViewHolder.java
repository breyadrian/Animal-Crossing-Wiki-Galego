package com.example.acwiki.screens.fish;

import android.app.Activity;
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


    public FishViewHolder(@NonNull View itemView) {
        super(itemView);

        this.id = (TextView) itemView.findViewById(R.id.id);
        this.fishName = (TextView) itemView.findViewById(R.id.fishName);
       // this.image_uri = (ImageView) itemView.findViewById(R.id.image_uri);
        this.icon_uri = (ImageView) itemView.findViewById(R.id.icon_uri);
    }
    public void showData(FishData data, Activity activity) {


      //  Picasso.get().load(data.getImage_uri()).into(image_uri);
        Picasso.get().load(data.getIcon_uri()).into(icon_uri);

        String str = data.getName();
        String firstLtr = str.substring(0, 1);
        String restLtrs = str.substring(1, str.length());

        firstLtr = firstLtr.toUpperCase();
        str = firstLtr + restLtrs;
        fishName.setText("Nome: " + str);
        id.setText("Id: "+ String.valueOf(data.getId()));
    }
}
