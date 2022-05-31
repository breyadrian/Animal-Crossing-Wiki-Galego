package com.example.acwiki.screens.music.Song;

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
import com.example.acwiki.screens.music.MusicData;
import com.example.acwiki.screens.music.SongData;
import com.example.acwiki.screens.music.background.DetailMusicActivity;

public class SongViewHolder extends RecyclerView.ViewHolder {

    private final TextView id;
    private final TextView disco;
    private final ImageView portada;

    //  private final ImageView image_uri;

    private final CardView cardView;


    public SongViewHolder(@NonNull View itemView) {
        super(itemView);
        this.cardView= (CardView) itemView.findViewById(R.id.musicCardView);
        this.id = (TextView) itemView.findViewById(R.id.id);
        this.disco = (TextView) itemView.findViewById(R.id.SongName);
        this.portada= (ImageView) itemView.findViewById(R.id.portadaDisco);
        // this.image_uri = (ImageView) itemView.findViewById(R.id.image_uri);

    }
    public void showData(SongData data, Activity activity) {

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, DetailSongActivity.class);
                intent.putExtra("data", data);

                activity.startActivity(intent);
            }
        });

        Bitmap bm= BitmapFactory.decodeByteArray(data.getImage_uri(), 0 ,data.getImage_uri().length);

        disco.setText(String.valueOf(data.getName()));
        portada.setImageBitmap(bm);
        id.setText("Id: "+ data.getId());


    }
}