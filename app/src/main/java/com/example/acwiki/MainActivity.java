package com.example.acwiki;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import com.example.acwiki.client.DTOs.BugsDTO;
import com.example.acwiki.client.DTOs.FishDTO;
import com.example.acwiki.client.DTOs.VillagerDTO;
import com.example.acwiki.client.RestClient;
import com.example.acwiki.client.handlers.GetBugsHandler;
import com.example.acwiki.client.handlers.GetFishHandler;
import com.example.acwiki.client.handlers.GetVillagerHandler;
import com.example.acwiki.screens.bugs.BugsActivity;
import com.example.acwiki.screens.fish.FishActivity;
import com.example.acwiki.screens.fish.FishData;
import com.example.acwiki.screens.villagers.VillagerActivity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void onFishButtonPressed(View view) {
        Intent intent = new Intent(this, FishActivity.class);
        startActivity(intent);
    }
    public void onVillagerButtonPressed(View view) {
        Intent intent = new Intent(this, VillagerActivity.class);
        startActivity(intent);
    }

    public void onBugsButtonPressed(View view) {
        Intent intent = new Intent(this, BugsActivity.class);
        startActivity(intent);
    }

    public void registrarDatos(View view){
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.custom_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent
        );

        registrarVillager(view);

        registrarPeces(view);

        registrarBichos(view);

    }


    public void registrarBichos(View view){

        RestClient.getInstance(this).getBugs(this, new GetBugsHandler() {
            @Override
            public void requestDidFail(int statusCode) {
                System.out.println("la peticion falló");
                System.out.println(statusCode);
            }

            @Override
            public void requestComplete(List<BugsDTO> dto, Activity activity) {
                insertarDatosBugs(dto,activity);

            }
        });


    }
    public void registrarVillager(View view){

        RestClient.getInstance(this).getVilagers(this, new GetVillagerHandler() {
            @Override
            public void requestDidFail(int statusCode) {
                System.out.println("la peticion falló");
                System.out.println(statusCode);
            }

            @Override
            public void requestComplete(List<VillagerDTO> dto, Activity activity) {
                insertarDatosVillager(dto,activity);

            }
        });


    }



    public void registrarPeces(View view){
        RestClient.getInstance(this).getFish(this, new GetFishHandler() {
            @Override
            public void requestDidFail(int statusCode) {
                System.out.println("la peticion falló");
                System.out.println(statusCode);
            }
            @Override
            public void requestComplete(List<FishDTO> dto, Activity activity) {
               insertarDatosFish(dto,activity);
            }
        });
    }
    private void insertarDatosFish(List<FishDTO> dto, Activity activity){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( activity, "administracion",null,1);
                SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
                List<FishData> data = new ArrayList<>();

                int c=0;

                ContentValues registro = new ContentValues();
                for (FishDTO dtoItem : dto) {
                    registro.put("id",dtoItem.getId());
                    registro.put("file_name",dtoItem.getFile_name());
                    registro.put("name",dtoItem.getName().getNameEUes());
                    registro.put("availabiliti", dtoItem.getAvailability().toString());
                    registro.put("shadow",dtoItem.getShadow());
                    registro.put("price",dtoItem.getPrice());
                    registro.put("price_cj",dtoItem.getPrice_cj());
                    registro.put("catch_phrase",dtoItem.getCatch_phrase());
                    registro.put("museum_phrase",dtoItem.getMuseum_phrase());

                    Bitmap image = getBitmapFromURL(dtoItem.getImage_uri());
                    ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
                    image.compress(Bitmap.CompressFormat.PNG, 0 , baos);
                    byte[] blob = baos.toByteArray();
                    registro.put("image",blob);

                    image = getBitmapFromURL(dtoItem.getIcon_uri());
                    baos = new ByteArrayOutputStream(2048);
                    image.compress(Bitmap.CompressFormat.PNG, 0 , baos);
                    blob = baos.toByteArray();
                    registro.put("icon",blob);
                    BaseDeDatos.insert("Fish",null,registro);
                    c++;
                    System.out.println(c);

                }

                BaseDeDatos.close();

            }
        });
        thread.start();
        while (thread.getState()!=Thread.State.TERMINATED){
        }

    }

    private void insertarDatosBugs(List<BugsDTO> dto, Activity activity){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( activity, "administracion",null,1);
                SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
                List<FishData> data = new ArrayList<>();

                int c=0;
                ContentValues registro = new ContentValues();
                for (BugsDTO dtoItem : dto) {
                    registro.put("id",dtoItem.getId());
                    registro.put("file_name",dtoItem.getFile_name());
                    registro.put("name",dtoItem.getName().getNameEUes());
                    registro.put("availabiliti", dtoItem.getAvailability().toString());
                    registro.put("price",dtoItem.getPrice());
                    registro.put("price_flick",dtoItem.getPrice_flick());
                    registro.put("catch_phrase",dtoItem.getCatch_phrase());
                    registro.put("museum_phrase",dtoItem.getMuseum_phrase());

                    Bitmap image = getBitmapFromURL(dtoItem.getImage_uri());
                    ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
                    image.compress(Bitmap.CompressFormat.PNG, 0 , baos);
                    byte[] blob = baos.toByteArray();
                    registro.put("image",blob);

                    image = getBitmapFromURL(dtoItem.getIcon_uri());
                    baos = new ByteArrayOutputStream(2048);
                    image.compress(Bitmap.CompressFormat.PNG, 0 , baos);
                    blob = baos.toByteArray();
                    registro.put("icon",blob);
                    BaseDeDatos.insert("Bugs",null,registro);
                    c++;
                    System.out.println(c);

                }

                BaseDeDatos.close();

            }
        });
        thread.start();
        while (thread.getState()!=Thread.State.TERMINATED){
            System.out.println("como andas");
        }

    }

    private void insertarDatosVillager(List<VillagerDTO> dto, Activity activity){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( activity, "administracion",null,1);
                SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
                List<FishData> data = new ArrayList<>();

                int c=0;
                ContentValues registro = new ContentValues();
                for (VillagerDTO dtoItem : dto) {
                    registro.put("id",dtoItem.getId());
                    registro.put("file_name",dtoItem.getFile_name());
                    registro.put("name",dtoItem.getName().getNameEUes());
                    registro.put("personality", dtoItem.getPersonality());
                    registro.put("birthday_string",dtoItem.getBirthday_string());
                    registro.put("birthday",dtoItem.getBirthday());
                    registro.put("species",dtoItem.getSpecies());
                    registro.put("gender",dtoItem.getGender());
                    registro.put("catch_phrase",dtoItem.getCatch_phrase());


                    Bitmap image = getBitmapFromURL(dtoItem.getImage_uri());
                    ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
                    image.compress(Bitmap.CompressFormat.PNG, 0 , baos);
                    byte[] blob = baos.toByteArray();
                    registro.put("image",blob);

                    image = getBitmapFromURL(dtoItem.getIcon_uri());
                    baos = new ByteArrayOutputStream(2048);
                    image.compress(Bitmap.CompressFormat.PNG, 0 , baos);
                    blob = baos.toByteArray();
                    registro.put("icon",blob);
                    BaseDeDatos.insert("Villagers",null,registro);
                    c++;
                    System.out.println(c);


                }

                BaseDeDatos.close();

            }
        });
        thread.start();
        while (thread.getState()!=Thread.State.TERMINATED){

        }
        dismissDialog();
    }




    public Bitmap getBitmapFromURL(String src) {
        try {
            java.net.URL url = new java.net.URL(src);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();

            connection.setDoInput(true);
            connection.connect();

            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);

            return myBitmap;
        } catch (IOException e) {
            System.out.println("alavaimariamatouse");
            e.printStackTrace();
            return null;
        }
    }


 public void dismissDialog(){
        progressDialog.dismiss();
 }

}