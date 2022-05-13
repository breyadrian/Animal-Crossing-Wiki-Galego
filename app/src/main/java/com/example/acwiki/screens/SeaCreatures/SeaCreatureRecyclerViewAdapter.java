package com.example.acwiki.screens.SeaCreatures;

import android.app.Activity;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acwiki.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SeaCreatureRecyclerViewAdapter extends RecyclerView.Adapter<SeaCreatureViewHolder> {
    private ArrayList<SeaCreatureData> allTheData;
    private ArrayList<SeaCreatureData> allTheOriginalData;
    private Activity activity;


    public SeaCreatureRecyclerViewAdapter(ArrayList<SeaCreatureData> allTheData, Activity activity) {
        this.allTheData = allTheData;
        this.activity = activity;
        allTheOriginalData= new ArrayList<SeaCreatureData>();
        allTheOriginalData.addAll(allTheData);

    }

    @Override
    public SeaCreatureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_sea_creature_view_holder, parent,
                false);
        return new SeaCreatureViewHolder(view);
    }





    @Override
    public void onBindViewHolder(@NonNull SeaCreatureViewHolder holder, int position) {
        SeaCreatureData dataInPositionToBeRendered = allTheData.get(position);
        holder.showData(dataInPositionToBeRendered, activity);

    }




    public void filtrado(final String txtBuscar){
        int longitud =txtBuscar.length();
        if(longitud==0){
            allTheData.clear();
            allTheData.addAll(allTheOriginalData);
        }else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                List<SeaCreatureData> collection = allTheData.stream()
                        .filter(i -> i.getName().toLowerCase().contains(txtBuscar.toLowerCase())).collect(Collectors.toList());
                allTheData.clear();
                allTheData.addAll(collection);
            }else{
                for (SeaCreatureData d:allTheOriginalData) {
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
