package com.example.acwiki.client.handlers;

import com.android.volley.Response;
import com.android.volley.VolleyError;

public class DefaultErrorHandler implements Response.ErrorListener{

    private final RestClientBaseResponseHandler baseHandler;


    public DefaultErrorHandler(RestClientBaseResponseHandler baseHandler) {
        this.baseHandler = baseHandler;
    }

    @Override
        public void onErrorResponse(VolleyError error) {
            int errorCode;
            error.printStackTrace();
            if (error.networkResponse != null) {
                errorCode = error.networkResponse.statusCode;
            } else {
                errorCode = -1;
            }
            this.baseHandler.requestDidFail(errorCode);
        }
    }
