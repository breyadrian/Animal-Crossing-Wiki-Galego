package com.example.acwiki.client.handlers;

import android.app.Activity;

import com.example.acwiki.client.DTOs.FishDTO;

import java.util.List;

public interface GetFishHandler extends RestClientBaseResponseHandler {
    void requestComplete(List<FishDTO> dto, Activity activity);
}

