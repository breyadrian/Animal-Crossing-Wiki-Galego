package com.example.acwiki.client.handlers;

import android.app.Activity;


import com.example.acwiki.client.DTOs.ItemDTO;

import java.util.List;

public interface GetItemHandler extends RestClientBaseResponseHandler {
    void requestComplete(List<ItemDTO> dto, Activity activity);
}
