package com.example.acwiki.client.handlers;

import android.app.Activity;

import com.example.acwiki.client.DTOs.BackgroundMusicDTO;


import java.util.List;

public interface GetMusicHandler extends RestClientBaseResponseHandler {
    void requestComplete(List<BackgroundMusicDTO> dto, Activity activity);
}
