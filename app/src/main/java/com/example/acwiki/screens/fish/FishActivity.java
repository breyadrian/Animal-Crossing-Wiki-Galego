package com.example.acwiki.screens.fish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import com.example.acwiki.R;
import com.example.acwiki.client.DTOs.FishDTO;
import com.example.acwiki.client.RestClient;
import com.example.acwiki.client.handlers.GetFishHandler;

import java.util.ArrayList;
import java.util.List;

public class FishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish);
        List<FishData> data = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.fishRecyclerView);
        Activity activity =this;


        RestClient.getInstance(this).getFish(this, new GetFishHandler() {
            @Override
            public void requestDidFail(int statusCode) {
                System.out.println("la peticion falló");
                System.out.println(statusCode);
            }

            @Override
            public void requestComplete(List<FishDTO> dto, Activity activity) {
                for (FishDTO dtoItem : dto) {
                    data.add(new FishData(dtoItem.getId(), dtoItem.getName().getNameEUes(), dtoItem.getImage_uri(), dtoItem.getIcon_uri()));
                }
                FishRecyclerViewAdapter adapter = new FishRecyclerViewAdapter(data, activity);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(activity.getApplicationContext()));
            }
        });
    }




}