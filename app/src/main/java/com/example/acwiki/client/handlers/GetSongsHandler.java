package com.example.acwiki.client.handlers;

import android.app.Activity;


import com.example.acwiki.client.DTOs.SongDTO;

import java.util.List;

public interface GetSongsHandler extends RestClientBaseResponseHandler {
    void requestComplete(List<SongDTO> dto, Activity activity);
}
