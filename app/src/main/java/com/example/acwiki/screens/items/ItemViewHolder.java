package com.example.acwiki.screens.items;

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
                Intent intent = new Intent(activity, DetailFishActivity.class);
                intent.putExtra("variant", data.getName());
                intent.putExtra("body_title", data.getImage_uri());
                intent.putExtra("pattern",data.getInternal_id());
                intent.putExtra("pattern_title",data.getPattern_title());
                intent.putExtra("isDiy",data.getIsDiy());
                intent.putExtra("canCustomizeBody",data.getCanCustomizeBody());
                intent.putExtra("canCustomizePattern",data.getCanCustomizePattern());
                intent.putExtra("kit_cost", data.getKit_cost());
                intent.putExtra("color1", data.getColor1());
                intent.putExtra("color2",data.getColor2());
                intent.putExtra("size",data.getSize());
                intent.putExtra("source",data.getSource());
                intent.putExtra("source_detail",data.getSource_detail());
                intent.putExtra("version",data.getVersion());
                intent.putExtra("hha_concept_1", data.getHha_concept_1());
                intent.putExtra("hha_concept_2", data.getHha_concept_2());
                intent.putExtra("hha_series",data.getHha_series());
                intent.putExtra("hha_set",data.getHha_set());
                intent.putExtra("isInteractive",data.getIsInteractive());
                intent.putExtra("tag",data.getTag());
                intent.putExtra("isOutdoor",data.getIsOutdoor());
                intent.putExtra("speaker_type", data.getSpeaker_type());
                intent.putExtra("lighting_type", data.getLighting_type());
                intent.putExtra("isDoorDeco",data.getIsDoorDeco());
                intent.putExtra("isCatalog",data.getIsCatalog());
                intent.putExtra("file_name",data.getFile_name());
                intent.putExtra("variant_id",data.getVariant_id());
                intent.putExtra("internal_id",data.getInternal_id());
                intent.putExtra("nombre", data.getName());
                intent.putExtra("buy_price", data.getBuy_price());
                intent.putExtra("sell_price",data.getSell_price());
                intent.putExtra("image_uri",data.getImage_uri());


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

        id.setText("Id: "+ data.getAppID());


    }
}
