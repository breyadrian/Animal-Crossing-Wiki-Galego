package com.example.acwiki.client.handlers;

import android.app.Activity;

import com.example.acwiki.client.DTOs.BugsDTO;

import java.util.List;

public interface GetBugsHandler extends RestClientBaseResponseHandler {
    void requestComplete(List<BugsDTO> dto, Activity activity);
}


