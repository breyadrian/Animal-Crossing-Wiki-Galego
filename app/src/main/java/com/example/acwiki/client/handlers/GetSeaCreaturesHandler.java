package com.example.acwiki.client.handlers;

import android.app.Activity;


import com.example.acwiki.client.DTOs.SeaCreaturesDTO;

import java.util.List;

public interface GetSeaCreaturesHandler extends RestClientBaseResponseHandler {
    void requestComplete(List<SeaCreaturesDTO> dto, Activity activity);
}
