package com.example.acwiki.client.handlers;

import android.app.Activity;


import com.example.acwiki.client.DTOs.VillagerDTO;

import java.util.List;

public interface GetVillagerHandler extends RestClientBaseResponseHandler {
    void requestComplete(List<VillagerDTO> dto, Activity activity);
}
