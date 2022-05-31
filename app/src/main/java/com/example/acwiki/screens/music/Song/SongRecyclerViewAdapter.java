package com.example.acwiki.screens.music.Song;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acwiki.R;
import com.example.acwiki.screens.music.MusicData;
import com.example.acwiki.screens.music.SongData;

import java.util.ArrayList;

public class SongRecyclerViewAdapter extends RecyclerView.Adapter<SongViewHolder> {
    private ArrayList<SongData> allTheData;
    private ArrayList<SongData> allTheOriginalData;
    private Activity activity;


    public SongRecyclerViewAdapter(ArrayList<SongData> allTheData,Activity activity) {
        this.allTheData = allTheData;
        this.activity = activity;
        allTheOriginalData= new ArrayList<SongData>();
        allTheOriginalData.addAll(allTheData);

    }

    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_song_view_holder, parent,
                false);
        return new SongViewHolder(view);
    }





    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        SongData dataInPositionToBeRendered = allTheData.get(position);
        holder.showData(dataInPositionToBeRendered, activity);

    }





    @Override
    public int getItemCount() {
        return allTheData.size();
    }




}
