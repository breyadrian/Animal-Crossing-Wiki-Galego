package com.example.acwiki.screens.music.background;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acwiki.R;
import com.example.acwiki.screens.music.MusicData;
import com.example.acwiki.screens.music.background.MusicViewHolder;

import java.util.ArrayList;

public class MusicRecyclerViewAdapter  extends RecyclerView.Adapter<MusicViewHolder> {
    private ArrayList<MusicData> allTheData;
    private ArrayList<MusicData> allTheOriginalData;
    private Activity activity;


    public MusicRecyclerViewAdapter(ArrayList<MusicData> allTheData,Activity activity) {
        this.allTheData = allTheData;
        this.activity = activity;
        allTheOriginalData= new ArrayList<MusicData>();
        allTheOriginalData.addAll(allTheData);

    }

    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_music_view_holder, parent,
                false);
        return new MusicViewHolder(view);
    }





    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {
        MusicData dataInPositionToBeRendered = allTheData.get(position);
        holder.showData(dataInPositionToBeRendered, activity);

    }





    @Override
    public int getItemCount() {
        return allTheData.size();
    }




}
