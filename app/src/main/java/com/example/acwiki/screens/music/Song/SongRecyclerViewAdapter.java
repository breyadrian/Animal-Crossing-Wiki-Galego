package com.example.acwiki.screens.music.Song;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acwiki.R;
import com.example.acwiki.screens.art.ArtData;
import com.example.acwiki.screens.music.MusicData;
import com.example.acwiki.screens.music.SongData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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


    public void filtrado(final String txtBuscar){
        int longitud =txtBuscar.length();
        if(longitud==0){
            allTheData.clear();
            allTheData.addAll(allTheOriginalData);
        }else{
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<SongData> collection = allTheOriginalData.stream()
                        .filter(i -> i.getName().toLowerCase().contains(txtBuscar.toLowerCase())).collect(Collectors.toList());
                allTheData.clear();
                allTheData.addAll(collection);
            }else{
                for (SongData d:allTheOriginalData) {
                    if(d.getName().toLowerCase().contains(txtBuscar.toLowerCase())){
                        allTheData.add(d);
                    }
                }
            }
            notifyDataSetChanged();
        }


    }


    @Override
    public int getItemCount() {
        return allTheData.size();
    }




}
