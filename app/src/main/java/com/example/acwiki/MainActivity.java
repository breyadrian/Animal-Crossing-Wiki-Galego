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

import com.example.acwiki.client.DTOs.ArtDTO;
import com.example.acwiki.client.DTOs.BugsDTO;
import com.example.acwiki.client.DTOs.FishDTO;
import com.example.acwiki.client.DTOs.FossilDTO;
import com.example.acwiki.client.DTOs.ItemDTO;
import com.example.acwiki.client.DTOs.SeaCreaturesDTO;
import com.example.acwiki.client.DTOs.VillagerDTO;
import com.example.acwiki.client.RestClient;
import com.example.acwiki.client.handlers.GetArtHandler;
import com.example.acwiki.client.handlers.GetBugsHandler;
import com.example.acwiki.client.handlers.GetFishHandler;
import com.example.acwiki.client.handlers.GetFossilHandler;
import com.example.acwiki.client.handlers.GetItemHandler;
import com.example.acwiki.client.handlers.GetSeaCreaturesHandler;
import com.example.acwiki.client.handlers.GetVillagerHandler;
import com.example.acwiki.screens.SeaCreatures.SeaCreatureActivity;
import com.example.acwiki.screens.art.ArtActivity;
import com.example.acwiki.screens.bugs.BugsActivity;
import com.example.acwiki.screens.fish.FishActivity;
import com.example.acwiki.screens.fossils.FossilActivity;
import com.example.acwiki.screens.items.ItemActivity;
import com.example.acwiki.screens.villagers.VillagerActivity;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        View itemImage = findViewById(R.id.itemImage);
        View fishImage = findViewById(R.id.fishImage);
        View bugImage = findViewById(R.id.bugImage);
        View fosilImage = findViewById(R.id.fossilIcon);
        View criaturasIamge = findViewById(R.id.criaturasIamge);
        View aldeanoImage = findViewById(R.id.aldeanoImage);
        View artImage = findViewById(R.id.artImage);

        artImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // SecondActivty is the name of new created EmptyActivity.
                Intent intent = new Intent(MainActivity.this, ArtActivity.class);
                startActivity(intent);
            }
        });

        itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // SecondActivty is the name of new created EmptyActivity.
                Intent intent = new Intent(MainActivity.this, ItemActivity.class);
                startActivity(intent);
            }
        });

        fishImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // SecondActivty is the name of new created EmptyActivity.
                Intent intent = new Intent(MainActivity.this, FishActivity.class);
                startActivity(intent);
            }
        });

        bugImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // SecondActivty is the name of new created EmptyActivity.
                Intent intent = new Intent(MainActivity.this, BugsActivity.class);
                startActivity(intent);
            }
        });

        criaturasIamge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // SecondActivty is the name of new created EmptyActivity.
                Intent intent = new Intent(MainActivity.this, SeaCreatureActivity.class);
                startActivity(intent);
            }
        });

        fosilImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // SecondActivty is the name of new created EmptyActivity.
                Intent intent = new Intent(MainActivity.this, FossilActivity.class);
                startActivity(intent);
            }
        });

        aldeanoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // SecondActivty is the name of new created EmptyActivity.
                Intent intent = new Intent(MainActivity.this, VillagerActivity.class);
                startActivity(intent);
            }
        });

    }


    public void registrarDatos(View view){
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.custom_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent
        );
        registrarArte(view);
        registrarSeaCreatures(view);
        registrarFossil(view);
        registrarPeces(view);
        registrarBichos(view);
        registrarVillager(view);
        registrarItems(view);

    }


    public void registrarArte(View view){
        RestClient.getInstance(this).getArt(this, new GetArtHandler() {
            @Override
            public void requestDidFail(int statusCode) {
                System.out.println("la peticion falló");
                System.out.println(statusCode);
            }

            @Override
            public void requestComplete(List<ArtDTO> dto, Activity activity) {
                insertarDatosArte(dto,activity);

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

    public void registrarSeaCreatures(View view){
        RestClient.getInstance(this).getSeaCreatures(this, new GetSeaCreaturesHandler() {
            @Override
            public void requestDidFail(int statusCode) {
                System.out.println("la peticion falló");
                System.out.println(statusCode);
            }
            @Override
            public void requestComplete(List<SeaCreaturesDTO> dto, Activity activity) {
                insertarDatosSeaCreature(dto,activity);
            }
        });
    }
    public void registrarFossil(View view){
        RestClient.getInstance(this).getFossil(this, new GetFossilHandler() {
            @Override
            public void requestDidFail(int statusCode) {
                System.out.println("la peticion falló");
                System.out.println(statusCode);
            }
            @Override
            public void requestComplete(List<FossilDTO> dto, Activity activity) {
                insertarDatosFossils(dto,activity);
            }
        });
    }


    public void registrarItems(View view){
        RestClient.getInstance(this).getItemCasa(this, new GetItemHandler() {
            @Override
            public void requestDidFail(int statusCode) {
                System.out.println("la peticion falló");
                System.out.println(statusCode);
            }
            @Override
            public void requestComplete(List<ItemDTO> dto, Activity activity) {
                insertarDatosItem(dto,activity);
            }
        });

        RestClient.getInstance(this).getItemVarios(this, new GetItemHandler() {
            @Override
            public void requestDidFail(int statusCode) {
                System.out.println("la peticion falló");
                System.out.println(statusCode);
            }
            @Override
            public void requestComplete(List<ItemDTO> dto, Activity activity) {
                insertarDatosItem(dto,activity);
            }
        });
        RestClient.getInstance(this).getItemPared(this, new GetItemHandler() {
            @Override
            public void requestDidFail(int statusCode) {
                System.out.println("la peticion falló");
                System.out.println(statusCode);
            }
            @Override
            public void requestComplete(List<ItemDTO> dto, Activity activity) {
                insertarDatosItem(dto,activity);
            }
        });

    }


    private void insertarDatosFish(List<FishDTO> dto, Activity activity){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( activity, "administracion",null,1);
                SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

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
                    System.out.println("Fish: "+c);

                }

                BaseDeDatos.close();

            }
        });
        thread.start();
        while (thread.getState()!=Thread.State.TERMINATED){
        }

    }
    private void insertarDatosArte(List<ArtDTO> dto, Activity activity){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( activity, "administracion",null,1);
                SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

                int c=0;
                ContentValues registro = new ContentValues();
                for (ArtDTO dtoItem : dto) {
                    registro.put("id",dtoItem.getId());
                    registro.put("file_name",dtoItem.getFile_name());
                    registro.put("name",dtoItem.getName().getNameEUes());
                    registro.put("hasFake",dtoItem.HasFake());
                    registro.put("buy_price",dtoItem.getBuy_price());
                    registro.put("sell_price",dtoItem.getSell_price());
                    registro.put("museum_desc",dtoItem.getMuseum_desc());

                    Bitmap image = getBitmapFromURL(dtoItem.getImage_uri());
                    ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
                    image.compress(Bitmap.CompressFormat.PNG, 0 , baos);
                    byte[] blob = baos.toByteArray();
                    registro.put("image",blob);
                    BaseDeDatos.insert("Arte",null,registro);
                    c++;
                    System.out.println("arte: "+c);
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
                    System.out.println("Bug: "+c);
                }

                BaseDeDatos.close();

            }
        });
        thread.start();
        while (thread.getState()!=Thread.State.TERMINATED){
        }

    }

    private void insertarDatosVillager(List<VillagerDTO> dto, Activity activity){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( activity, "administracion",null,1);
                SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
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
                    System.out.println("Villager: "+c);
                }
                BaseDeDatos.close();
            }
        });
        thread.start();
        while (thread.getState()!=Thread.State.TERMINATED){
        }
        dismissDialog();
    }

    private void insertarDatosSeaCreature(List<SeaCreaturesDTO> dto, Activity activity){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( activity, "administracion",null,1);
                SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();


                int c=0;

                ContentValues registro = new ContentValues();
                for (SeaCreaturesDTO dtoItem : dto) {
                    registro.put("id",dtoItem.getId());
                    registro.put("file_name",dtoItem.getFile_name());
                    registro.put("name",dtoItem.getName().getNameEUes());
                    registro.put("availabiliti", dtoItem.getAvailability().toString());
                    registro.put("speed",dtoItem.getSpeed());
                    registro.put("shadow",dtoItem.getShadow());
                    registro.put("price",dtoItem.getPrice());
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

                    BaseDeDatos.insert("SeaCreatures",null,registro);
                    c++;
                    System.out.println("SeaCreature: "+c);

                }

                BaseDeDatos.close();

            }
        });
        thread.start();
        while (thread.getState()!=Thread.State.TERMINATED){
        }

    }

    private void insertarDatosFossils(List<FossilDTO> dto, Activity activity){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( activity, "administracion",null,1);
                SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();


                int c=0;

                ContentValues registro = new ContentValues();
                for (FossilDTO dtoItem : dto) {
                    registro.put("file_name",dtoItem.getFile_name());
                    registro.put("name",dtoItem.getName().getNameEUes());
                    registro.put("price",dtoItem.getPrice());
                    registro.put("museum_phrase",dtoItem.getMuseum_phrase());

                    Bitmap image = getBitmapFromURL(dtoItem.getImage_uri());
                    ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
                    image.compress(Bitmap.CompressFormat.PNG, 0 , baos);
                    byte[] blob = baos.toByteArray();

                    registro.put("image",blob);
                    registro.put("part_of",dtoItem.getPart_of());

                    BaseDeDatos.insert("Fossils",null,registro);
                    c++;
                    System.out.println("Fossil: "+c);

                }

                BaseDeDatos.close();

            }
        });
        thread.start();
        while (thread.getState()!=Thread.State.TERMINATED){
        }

    }


    private void insertarDatosItem(List<ItemDTO> dto, Activity activity){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( activity, "administracion",null,1);
                SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();


                int c=0;

                ContentValues registro = new ContentValues();
                for (ItemDTO dtoItem : dto) {
                    registro.put("variant",dtoItem.getVariant());
                    registro.put("body_title",dtoItem.getFile_name());
                    registro.put("pattern",dtoItem.getName().getNameEUes());
                    registro.put("pattern_title",dtoItem.getPattern_title());
                    registro.put("isDiy",dtoItem.isDiy());
                    registro.put("canCustomizeBody",dtoItem.isCanCustomizeBody());
                    registro.put("canCustomizePattern",dtoItem.isCanCustomizePattern());
                    registro.put("kit_cost",dtoItem.getKit_cost());
                    registro.put("color1",dtoItem.getColor1());
                    registro.put("color2",dtoItem.getColor2());
                    registro.put("size",dtoItem.getSize());
                    registro.put("source",dtoItem.getSource());
                    registro.put("source_detail",dtoItem.getSource_detail());
                    registro.put("version",dtoItem.getVersio());
                    registro.put("hha_concept_1",dtoItem.getHha_concept_1());
                    registro.put("hha_concept_2",dtoItem.getHha_concept_2());
                    registro.put("hha_series",dtoItem.getHha_series());
                    registro.put("hha_set",dtoItem.getHha_set());
                    registro.put("isInteractive",dtoItem.isInteractive());
                    registro.put("tag",dtoItem.getTag());
                    registro.put("isOutdoor",dtoItem.isOutdoor());
                    registro.put("speaker_type",dtoItem.getSpeaker_type());
                    registro.put("lighting_type",dtoItem.getLighting_type());
                    registro.put("isDoorDeco",dtoItem.isDoorDeco());
                    registro.put("isCatalog",dtoItem.isCatalog());
                    registro.put("file_name",dtoItem.getFile_name());
                    registro.put("variant_id",dtoItem.getVariant_id());
                    registro.put("internal_id",dtoItem.getInternal_id());
                    registro.put("name",dtoItem.getName().getNameEUes());
                    registro.put("buy_price",dtoItem.getBuy_price());
                    registro.put("sell_price",dtoItem.getSell_price());


                        Bitmap image = getBitmapFromURL(dtoItem.getImage_uri());

                        if(image==null) {
                           registro.put("image", (byte[]) null);
                        }else{
                            ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
                            image.compress(Bitmap.CompressFormat.PNG, 0, baos);
                            byte[] blob = baos.toByteArray();
                            registro.put("image", blob);
                        }


                    BaseDeDatos.insert("Items",null,registro);
                    c++;
                    System.out.println("item: "+c);

                }

                BaseDeDatos.close();

            }
        });
        thread.start();
        while (thread.getState()!=Thread.State.TERMINATED){
        }

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
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            return null;
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