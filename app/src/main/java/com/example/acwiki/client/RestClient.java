package com.example.acwiki.client;

import android.app.Activity;
import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.acwiki.client.DTOs.BugsDTO;
import com.example.acwiki.client.DTOs.FishDTO;
import com.example.acwiki.client.DTOs.FossilDTO;
import com.example.acwiki.client.DTOs.ItemDTO;
import com.example.acwiki.client.DTOs.SeaCreaturesDTO;
import com.example.acwiki.client.DTOs.VillagerDTO;
import com.example.acwiki.client.handlers.DefaultErrorHandler;
import com.example.acwiki.client.handlers.GetBugsHandler;
import com.example.acwiki.client.handlers.GetFishHandler;
import com.example.acwiki.client.handlers.GetFossilHandler;
import com.example.acwiki.client.handlers.GetItemHandler;
import com.example.acwiki.client.handlers.GetSeaCreaturesHandler;
import com.example.acwiki.client.handlers.GetVillagerHandler;

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
                new DefaultErrorHandler(handler)
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
                new DefaultErrorHandler(handler)
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

    public void getVilagers(Activity activity, GetVillagerHandler handler) {
        String url = REST_API_BASE_URL + "/villagers/";
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null, // Es un GET. No puede viajar nada en el cuerpo de la petición.
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        List<VillagerDTO> finalResult = new ArrayList<>();
                        Iterator<?> keys = response.keys();

                        while( keys.hasNext() ) {
                            String key = (String) keys.next();
                            System.out.println("Key: " + key);

                            try {
                                String s=key;
                                JSONObject villager = response.getJSONObject(key);
                                finalResult.add(new VillagerDTO(villager));
                            } catch (JSONException e) {
                                e.printStackTrace();
                                handler.requestDidFail(-1);
                            }
                        }
                        handler.requestComplete(finalResult, activity);
                    }
                },
                new DefaultErrorHandler(handler)
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

    public void getSeaCreatures(Activity activity, GetSeaCreaturesHandler handler) {
        String url = REST_API_BASE_URL + "/sea/";
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null, // Es un GET. No puede viajar nada en el cuerpo de la petición.
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        List<SeaCreaturesDTO> finalResult = new ArrayList<>();
                        Iterator<?> keys = response.keys();

                        while( keys.hasNext() ) {
                            String key = (String) keys.next();
                            System.out.println("Key: " + key);

                            try {
                                String s=key;
                                JSONObject creature = response.getJSONObject(key);
                                finalResult.add(new SeaCreaturesDTO(creature));
                            } catch (JSONException e) {
                                e.printStackTrace();
                                handler.requestDidFail(-1);
                            }
                        }
                        handler.requestComplete(finalResult, activity);
                    }
                },
                new DefaultErrorHandler(handler)
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

    public void getFossil(Activity activity, GetFossilHandler handler) {
        String url = REST_API_BASE_URL + "/fossils/";
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null, // Es un GET. No puede viajar nada en el cuerpo de la petición.
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        List<FossilDTO> finalResult = new ArrayList<>();
                        Iterator<?> keys = response.keys();

                        while( keys.hasNext() ) {
                            String key = (String) keys.next();
                            System.out.println("Key: " + key);

                            try {
                                String s=key;
                                JSONObject fossil = response.getJSONObject(key);
                                finalResult.add(new FossilDTO(fossil));
                            } catch (JSONException e) {
                                e.printStackTrace();
                                handler.requestDidFail(-1);
                            }
                        }
                        handler.requestComplete(finalResult, activity);
                    }
                },
                new DefaultErrorHandler(handler)
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

    public void getItemCasa(Activity activity, GetItemHandler handler) {
        String url = REST_API_BASE_URL + "/houseware/";
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null, // Es un GET. No puede viajar nada en el cuerpo de la petición.
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        List<JSONObject> result = new ArrayList<>();
                        List<ItemDTO> finalResult= new ArrayList<>();
                        Iterator<?> keys = response.keys();

                        while( keys.hasNext() ) {
                            String key = (String) keys.next();
                            System.out.println("Key: " + key);
                            try {
                                String s=key;
                                JSONArray item = response.getJSONArray(key);

                                for(int i=0; i<item.length();i++){
                                    result.add(item.getJSONObject(i));
                                }
                                finalResult = new ArrayList<>();
                                for(int i=0;i<result.size();i++){
                                    finalResult.add(new ItemDTO(result.get(i)));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                handler.requestDidFail(-1);
                            }
                        }
                        handler.requestComplete(finalResult, activity);
                    }
                },
                new DefaultErrorHandler(handler)
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

    public void getItemPared(Activity activity, GetItemHandler handler) {
        String url = REST_API_BASE_URL + "/wallmounted/";
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null, // Es un GET. No puede viajar nada en el cuerpo de la petición.
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        List<JSONObject> result = new ArrayList<>();
                        List<ItemDTO> finalResult= new ArrayList<>();
                        Iterator<?> keys = response.keys();

                        while( keys.hasNext() ) {
                            String key = (String) keys.next();
                            System.out.println("Key: " + key);
                            try {
                                String s=key;
                                JSONArray item = response.getJSONArray(key);

                                for(int i=0; i<item.length();i++){
                                    result.add(item.getJSONObject(i));
                                }
                                finalResult = new ArrayList<>();
                                for(int i=0;i<result.size();i++){
                                    finalResult.add(new ItemDTO(result.get(i)));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                handler.requestDidFail(-1);
                            }
                        }
                        handler.requestComplete(finalResult, activity);
                    }
                },
                new DefaultErrorHandler(handler)
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

    public void getItemVarios(Activity activity, GetItemHandler handler) {
        String url = REST_API_BASE_URL + "/misc/";
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null, // Es un GET. No puede viajar nada en el cuerpo de la petición.
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        List<JSONObject> result = new ArrayList<>();
                        List<ItemDTO> finalResult= new ArrayList<>();
                        Iterator<?> keys = response.keys();

                        while( keys.hasNext() ) {
                            String key = (String) keys.next();
                            System.out.println("Key: " + key);
                            try {
                                String s=key;
                                JSONArray item = response.getJSONArray(key);

                                for(int i=0; i<item.length();i++){
                                    result.add(item.getJSONObject(i));
                                }
                                finalResult = new ArrayList<>();
                                for(int i=0;i<result.size();i++){
                                    finalResult.add(new ItemDTO(result.get(i)));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                handler.requestDidFail(-1);
                            }
                        }
                        handler.requestComplete(finalResult, activity);
                    }
                },
                new DefaultErrorHandler(handler)
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
