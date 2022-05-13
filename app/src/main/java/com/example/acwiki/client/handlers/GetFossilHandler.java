package com.example.acwiki.client.handlers;

import android.app.Activity;

import com.example.acwiki.client.DTOs.FossilDTO;

import java.util.List;

public interface GetFossilHandler extends RestClientBaseResponseHandler {
    void requestComplete(List<FossilDTO> dto, Activity activity);
}

