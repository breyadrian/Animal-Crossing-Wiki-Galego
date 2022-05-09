package com.example.acwiki.screens.fish;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acwiki.R;

import java.util.List;

public class FishRecyclerViewAdapter extends RecyclerView.Adapter<FishViewHolder> {
    private List<FishData> allTheData;
    private Activity activity;

    public FishRecyclerViewAdapter(List<FishData> allTheData, Activity activity) {
        this.allTheData = allTheData;
        this.activity = activity;
    }

    @Override
    public FishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_fish_view_holder, parent,
                false);
        return new FishViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FishViewHolder holder, int position) {
        FishData dataInPositionToBeRendered = allTheData.get(position);
        holder.showData(dataInPositionToBeRendered, activity);
    }

    @Override
    public int getItemCount() {
        return allTheData.size();
    }

}
