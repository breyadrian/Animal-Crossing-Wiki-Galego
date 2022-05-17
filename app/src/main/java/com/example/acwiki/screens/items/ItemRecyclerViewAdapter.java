package com.example.acwiki.screens.items;

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

public class ItemRecyclerViewAdapter  extends RecyclerView.Adapter<ItemViewHolder> {
    private ArrayList<ItemData> allTheData;
    private ArrayList<ItemData> allTheOriginalData;
    private Activity activity;

    public ItemRecyclerViewAdapter(ArrayList<ItemData> allTheData, Activity activity) {
        this.allTheData = allTheData;
        this.activity = activity;
        allTheOriginalData= new ArrayList<ItemData>();
        allTheOriginalData.addAll(allTheData);


    }

    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_view_holder, parent,
                false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
            ItemData dataInPositionToBeRendered = allTheData.get(position);
            holder.showData(dataInPositionToBeRendered, activity);
        }

    public void filtrado(final String txtBuscar){
        int longitud =txtBuscar.length();
        if(longitud==0){
            allTheData.clear();
            allTheData.addAll(allTheOriginalData);
        }else{
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<ItemData> collection = allTheData.stream()
                        .filter(i -> i.getName().toLowerCase().contains(txtBuscar.toLowerCase())).collect(Collectors.toList());
                allTheData.clear();
                allTheData.addAll(collection);
            }else{
                for (ItemData d:allTheOriginalData) {
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
