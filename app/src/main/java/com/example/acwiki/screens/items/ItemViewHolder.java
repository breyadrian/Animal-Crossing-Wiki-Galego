package com.example.acwiki.screens.items;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acwiki.R;
import com.example.acwiki.screens.fish.DetailFishActivity;
import com.example.acwiki.screens.fish.FishData;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    private final TextView id;
    private final TextView fishName;


    //  private final ImageView image_uri;
    private final ImageView icon_uri;
    private final CardView cardView;


    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        this.cardView= (CardView) itemView.findViewById(R.id.ItemCardView);
        this.id = (TextView) itemView.findViewById(R.id.id);
        this.fishName = (TextView) itemView.findViewById(R.id.itemName);

        // this.image_uri = (ImageView) itemView.findViewById(R.id.image_uri);
        this.icon_uri = (ImageView) itemView.findViewById(R.id.icon_uri);
    }
    public void showData(ItemData data, Activity activity) {


        //  Picasso.get().load(data.getImage_uri()).into(image_uri);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, DetailItemActivity.class);
                intent.putExtra("data", (Parcelable) data);



                activity.startActivity(intent);
            }
        });
        if (data.getImage_uri()!=null){

            Bitmap bm = BitmapFactory.decodeByteArray(data.getImage_uri(), 0, data.getImage_uri().length);
            icon_uri.setImageBitmap(bm);
        }
        String str = data.getName();
        String firstLtr = str.substring(0, 1);
        String restLtrs = str.substring(1, str.length());

        firstLtr = firstLtr.toUpperCase();
        str = firstLtr + restLtrs;
        fishName.setText("Nome: " + str);

        id.setText("Id: "+ data.getInternal_id());


    }
}
