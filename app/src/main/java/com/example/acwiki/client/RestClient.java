package com.example.acwiki.client;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.acwiki.client.DTOs.BugsDTO;
import com.example.acwiki.client.DTOs.FishDTO;
import com.example.acwiki.client.handlers.DefaultErrotHandler;
import com.example.acwiki.client.handlers.GetBugsHandler;
import com.example.acwiki.client.handlers.GetFishHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RestClient {

    private final RequestQueue queue;
    private final Context appContext;
    private int userId;
    private String userName;
    private String token;

    // La resolución del nombre de dominio en el DNS de la red local puede dar
    // problemas en ciertos emuladores.
    // La siguiente dirección usa la IP del servidor local en lugar de su nombre de dominio.
    private final String REST_API_BASE_URL = "http://acnhapi.com/v1";



    private static RestClient instance = null;

    private RestClient(Context context) {
        this.queue = Volley.newRequestQueue(context);
        this.appContext = context;
        // Try to obtain Login data from SharedPreferences

    }

    public static RestClient getInstance(Context context) {
        if (instance == null) {
            instance = new RestClient(context);
        }
        return instance;
    }
    public void getFish(Activity activity, GetFishHandler handler) {
        String url = REST_API_BASE_URL + "/fish/";
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null, // Es un GET. No puede viajar nada en el cuerpo de la petición.
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        List<FishDTO> finalResult = new ArrayList<>();
                        Iterator<?> keys = response.keys();

                        while( keys.hasNext() ) {
                            String key = (String) keys.next();
                            System.out.println("Key: " + key);


                            try {
                                String s=key;
                                JSONObject fish = response.getJSONObject(key);
                                finalResult.add(new FishDTO(fish));
                            } catch (JSONException e) {
                                e.printStackTrace();
                                handler.requestDidFail(-1);
                            }
                        }
                        handler.requestComplete(finalResult, activity);
                    }
                },
                new DefaultErrotHandler(handler)
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>(super.getHeaders());
                if (token != null) {

                    headers.put("token", token);
                }
                return headers;
            }
        };
        queue.add(request);
    }



    public void getBugs(Activity activity, GetBugsHandler handler) {
        String url = REST_API_BASE_URL + "/bugs/";
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null, // Es un GET. No puede viajar nada en el cuerpo de la petición.
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        List<BugsDTO> finalResult = new ArrayList<>();
                        Iterator<?> keys = response.keys();

                        while( keys.hasNext() ) {
                            String key = (String) keys.next();
                            System.out.println("Key: " + key);

                            try {
                                String s=key;
                                JSONObject bug = response.getJSONObject(key);
                                finalResult.add(new BugsDTO(bug));
                            } catch (JSONException e) {
                                e.printStackTrace();
                                handler.requestDidFail(-1);
                            }
                        }
                        handler.requestComplete(finalResult, activity);
                    }
                },
                new DefaultErrotHandler(handler)
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>(super.getHeaders());
                if (token != null) {

                    headers.put("token", token);
                }
                return headers;
            }
        };
        queue.add(request);
    }

    // Checks the presence of Auth Token in RESTClient.
    public boolean checkAuthToken() {
        return userId != -1 && token != null && userName != null;
    }
}
