package com.example.acwiki.screens.villagers;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acwiki.R;
import com.example.acwiki.client.DTOs.VillagerDTO;
import com.example.acwiki.screens.fish.FishData;
import com.example.acwiki.screens.fish.FishViewHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VillagerRecyclerViewAdapter extends RecyclerView.Adapter<VillagerViewHolder>{
    private ArrayList<VillagerData> allTheData;
    private ArrayList<VillagerData> allTheOriginalData;
    private Activity activity;

    public VillagerRecyclerViewAdapter(ArrayList<VillagerData> allTheData, Activity activity) {
        this.allTheData = allTheData;
        this.activity = activity;
        allTheOriginalData= new ArrayList<VillagerData>();
        allTheOriginalData.addAll(allTheData);

    }

    @Override
    public VillagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_villager_view_holder, parent,
                false);
        return new VillagerViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull VillagerViewHolder holder, int position) {
        VillagerData dataInPositionToBeRendered = allTheData.get(position);
        holder.showData(dataInPositionToBeRendered, activity);

    }




    public void filtrado(final String txtBuscar){
        int longitud =txtBuscar.length();
        if(longitud==0){
            allTheData.clear();
            allTheData.addAll(allTheOriginalData);
        }else{
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<VillagerData> collection = allTheOriginalData.stream()
                        .filter(i -> i.getName().toLowerCase().contains(txtBuscar.toLowerCase())).collect(Collectors.toList());
                allTheData.clear();
                allTheData.addAll(collection);
            }else{
                for (VillagerData d:allTheOriginalData) {
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
