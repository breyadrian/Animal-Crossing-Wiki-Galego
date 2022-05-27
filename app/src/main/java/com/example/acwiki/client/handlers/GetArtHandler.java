package com.example.acwiki.client.handlers;

import android.app.Activity;

import com.example.acwiki.client.DTOs.ArtDTO;


import java.util.List;

public interface GetArtHandler extends RestClientBaseResponseHandler {
    void requestComplete(List<ArtDTO> dto, Activity activity);
}
