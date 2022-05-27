package com.example.acwiki.screens.fossils.partes;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acwiki.R;
import com.example.acwiki.screens.fossils.FossilData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FosilPartRecyclerViewAdapter extends RecyclerView.Adapter<FossilPartViewHolder>{
    private ArrayList<FossilData> allTheData;
    private ArrayList<FossilData> allTheOriginalData;
    private Activity activity;

    public FosilPartRecyclerViewAdapter(ArrayList<FossilData> allTheData) {
        this.allTheData = allTheData;
        this.activity = activity;
        allTheOriginalData= new ArrayList<FossilData>();
        allTheOriginalData.addAll(allTheData);



    }
    @Override
    public FossilPartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_fossil_part_view_holder, parent,
                false);
        return new FossilPartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FossilPartViewHolder holder, int position) {
        FossilData dataInPositionToBeRendered = allTheData.get(position);
        holder.showData(dataInPositionToBeRendered);
    }


    public void filtrado(final String txtBuscar){
        int longitud =txtBuscar.length();
        if(longitud==0){
            allTheData.clear();
            allTheData.addAll(allTheOriginalData);
        }else{
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<FossilData> collection = allTheData.stream()
                        .filter(i -> i.getName().toLowerCase().contains(txtBuscar.toLowerCase())).collect(Collectors.toList());
                allTheData.clear();
                allTheData.addAll(collection);
            }else{
                for (FossilData d:allTheOriginalData) {
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
