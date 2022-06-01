package com.example.acwiki.screens.music.background;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.acwiki.R;
import com.example.acwiki.screens.music.MusicData;

public class MusicViewHolder extends RecyclerView.ViewHolder {

    private final TextView id;
    private final TextView fishName;


    //  private final ImageView image_uri;

    private final CardView cardView;


    public MusicViewHolder(@NonNull View itemView) {
        super(itemView);
        this.cardView= (CardView) itemView.findViewById(R.id.musicCardView);
        this.id = (TextView) itemView.findViewById(R.id.id);
        this.fishName = (TextView) itemView.findViewById(R.id.SongName);

        // this.image_uri = (ImageView) itemView.findViewById(R.id.image_uri);

    }
    public void showData(MusicData data, Activity activity) {

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, DetailMusicActivity.class);
                intent.putExtra("data", data);

                activity.startActivity(intent);
            }
        });


        fishName.setText("Hora: "+data.getHour()+" - Tempo: "+data.getWheather());

        id.setText("Id: "+ data.getId());


    }
}