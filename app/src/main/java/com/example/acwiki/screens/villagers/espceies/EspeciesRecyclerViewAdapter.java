package com.example.acwiki.screens.villagers.espceies;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acwiki.R;
import com.example.acwiki.screens.items.ItemData;
import com.example.acwiki.screens.items.varaintes.ItemVariantViewHolder;
import com.example.acwiki.screens.villagers.VillagerData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EspeciesRecyclerViewAdapter extends RecyclerView.Adapter<EspeciesViewHolder> {
    private ArrayList<VillagerData> allTheData;
    private ArrayList<VillagerData> allTheOriginalData;
    private Activity activity;


    public EspeciesRecyclerViewAdapter(ArrayList<VillagerData> allTheData,Activity activity) {
        this.allTheData = allTheData;
        this.activity = activity;
        allTheOriginalData= new ArrayList<VillagerData>();
        allTheOriginalData.addAll(allTheData);


    }

    @Override
    public EspeciesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_especies_view_holder, parent,
                false);
        return new EspeciesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EspeciesViewHolder holder, int position) {
        VillagerData dataInPositionToBeRendered = allTheData.get(position);
        holder.showData(dataInPositionToBeRendered,activity);
    }


    @Override
    public int getItemCount() {
        return allTheData.size();
    }




}
