package com.example.acwiki.screens.bugs;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acwiki.R;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BugsRecyclerViewAdapter extends RecyclerView.Adapter<BugsViewHolder>{
    private ArrayList<BugsData> allTheData;
    private ArrayList<BugsData> allTheOriginalData;
    private Activity activity;


    public BugsRecyclerViewAdapter(ArrayList<BugsData> allTheData, Activity activity) {
        this.allTheData = allTheData;
        this.activity = activity;
        allTheOriginalData= new ArrayList<BugsData>();
        allTheOriginalData.addAll(allTheData);

    }

    @Override
    public BugsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_bugs_view_holder, parent,
                false);
        return new BugsViewHolder(view);
    }




    @Override
    public void onBindViewHolder(@NonNull BugsViewHolder holder, int position) {
        BugsData dataInPositionToBeRendered = allTheData.get(position);
        holder.showData(dataInPositionToBeRendered, activity);

    }




    public void filtrado(final String txtBuscar){
        int longitud =txtBuscar.length();
        if(longitud==0){
            allTheData.clear();
            allTheData.addAll(allTheOriginalData);
        }else{
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<BugsData> collection = allTheData.stream()
                        .filter(i -> i.getName().toLowerCase().contains(txtBuscar.toLowerCase())).collect(Collectors.toList());
                allTheData.clear();
                allTheData.addAll(collection);
            }else{
                for (BugsData d:allTheOriginalData) {
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
