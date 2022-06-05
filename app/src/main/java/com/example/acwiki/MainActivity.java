package com.example.acwiki;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.ui.graphics.Color;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.acwiki.client.DTOs.ArtDTO;
import com.example.acwiki.client.DTOs.BackgroundMusicDTO;
import com.example.acwiki.client.DTOs.BugsDTO;
import com.example.acwiki.client.DTOs.FishDTO;
import com.example.acwiki.client.DTOs.FossilDTO;
import com.example.acwiki.client.DTOs.ItemDTO;
import com.example.acwiki.client.DTOs.SeaCreaturesDTO;
import com.example.acwiki.client.DTOs.SongDTO;
import com.example.acwiki.client.DTOs.VillagerDTO;
import com.example.acwiki.client.RestClient;
import com.example.acwiki.client.handlers.GetArtHandler;
import com.example.acwiki.client.handlers.GetBugsHandler;
import com.example.acwiki.client.handlers.GetFishHandler;
import com.example.acwiki.client.handlers.GetFossilHandler;
import com.example.acwiki.client.handlers.GetItemHandler;
import com.example.acwiki.client.handlers.GetMusicHandler;
import com.example.acwiki.client.handlers.GetSeaCreaturesHandler;
import com.example.acwiki.client.handlers.GetSongsHandler;
import com.example.acwiki.client.handlers.GetVillagerHandler;
import com.example.acwiki.screens.SeaCreatures.SeaCreatureActivity;
import com.example.acwiki.screens.art.ArtActivity;
import com.example.acwiki.screens.bugs.BugsActivity;
import com.example.acwiki.screens.fish.FishActivity;
import com.example.acwiki.screens.fossils.FossilActivity;
import com.example.acwiki.screens.items.ItemActivity;
import com.example.acwiki.screens.music.MusicActivity;
import com.example.acwiki.screens.villagers.VillagerActivity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder builderDescarga;
    ProgressDialog progressDialog;
    Activity activity=this;
    AlertDialog show;
    int peces=0,art=0,criaturas=0,bichos=0,aldeanos=0,items=0,canciones=0,musica=0,fosiles=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        if(!checkDataBase("/data/data/com.example.acwiki/databases/administracion")){
            builderDescarga = new AlertDialog.Builder(this);

            LayoutInflater inflater = this.getLayoutInflater();

            View v = inflater.inflate(R.layout.custom_dialog2, null);

            builderDescarga.setView(v);
            builderDescarga.create();
            builderDescarga.setCancelable(false);
            show = builderDescarga.show();



        }




        try {
            Field field = CursorWindow.class.getDeclaredField("sCursorWindowSize");
            field.setAccessible(true);
            field.set(null, 100 * 2048 * 2048); //the 100MB is the new size
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Skere");
        }
        View itemImage = findViewById(R.id.itemImage);
        View fishImage = findViewById(R.id.fishImage);
        View bugImage = findViewById(R.id.bugImage);
        View fosilImage = findViewById(R.id.fossilIcon);
        View criaturasIamge = findViewById(R.id.criaturasIamge);
        View aldeanoImage = findViewById(R.id.aldeanoImage);
        View musicImage = findViewById(R.id.musicImage);
        View artImage = findViewById(R.id.artImage);
        View config = findViewById(R.id.config);


        config.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createConfigDialog().show();
            }
        });


        musicImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // SecondActivty is the name of new created EmptyActivity.
                Intent intent = new Intent(MainActivity.this, MusicActivity.class);
                startActivity(intent);
            }
        });

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


    public void reiniciarBaseDatos(View view){
        this.deleteDatabase("/data/data/com.example.acwiki/databases/administracion");

        registrarDatos(view);

    }

    public void registrarDatos(View view){


        if(show!=null){
            show.dismiss();
        }

        Context context= this;
        Activity activity= this;

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setProgressStyle(progressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(6163);
        progressDialog.setTitle("Descargando...");
        progressDialog.setMessage("Este proceso pode tomar uns minutos, por favor ten paciencia");
        progressDialog.getWindow().setBackgroundDrawableResource(
                R.color.ACblue

        );
        progressDialog.show();

        progressDialog.setCancelable(false);


        Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {

        RestClient.getInstance(context).getBackgroundMusic(activity, new GetMusicHandler() {
            @Override
            public void requestDidFail(int statusCode) {
                System.out.println("la peticion falló");
                System.out.println(statusCode);
            }
            @Override
            public void requestComplete(List<BackgroundMusicDTO> dto, Activity activity) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( activity, "administracion",null,1);
                        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();


                        ContentValues registro = new ContentValues();
                        for (BackgroundMusicDTO dtoItem : dto) {
                            registro.put("id",dtoItem.getId());
                            registro.put("file_name",dtoItem.getFile_name());

                            registro.put("hour",dtoItem.getHour());
                            registro.put("wheather",dtoItem.getWheather());
                            System.out.println(dtoItem.getMusic_uri());
                            registro.put("music_uri", getMusica(dtoItem.getMusic_uri()));


                            BaseDeDatos.insert("Musica",null,registro);

                            musica++;
                            updateDialog();
                            System.out.println("Musica: "+musica);
                        }

                        BaseDeDatos.close();

                    }
                });
                thread.start();

            }
        });
        RestClient.getInstance(context).getSongs(activity, new GetSongsHandler() {
            @Override
            public void requestDidFail(int statusCode) {
                System.out.println("la peticion falló");
                System.out.println(statusCode);
            }
            @Override
            public void requestComplete(List<SongDTO> dto, Activity activity) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( activity, "administracion",null,1);
                        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();


                        ContentValues registro = new ContentValues();
                        for (SongDTO dtoItem : dto) {
                            registro.put("id",dtoItem.getId());
                            registro.put("file_name",dtoItem.getFile_name());
                            registro.put("name",dtoItem.getName().getNameEUes());
                            registro.put("buy_price",dtoItem.getBuy_price());
                            registro.put("sell_price",dtoItem.getSell_price());
                            registro.put("isOrderable",dtoItem.isOrderable());
                            System.out.println(dtoItem.getMusic_uri());
                            registro.put("music_uri", getMusica(dtoItem.getMusic_uri()));

                            Bitmap image = getBitmapFromURL(dtoItem.getImage_uri());
                            ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
                            image.compress(Bitmap.CompressFormat.JPEG , 75, baos);
                            byte[] blob = baos.toByteArray();


                            registro.put("image_uri",blob);

                            BaseDeDatos.insert("Canciones",null,registro);

                            canciones++;
                            System.out.println("Cancion: "+canciones);
                            updateDialog();
                        }

                        BaseDeDatos.close();

                    }
                });
                thread.start();

            }
        });
        RestClient.getInstance(context).getArt(activity, new GetArtHandler()    {
            @Override
            public void requestDidFail(int statusCode) {
                System.out.println("la peticion falló");
                System.out.println(statusCode);
            }

            @Override
            public void requestComplete(List<ArtDTO> dto, Activity activity) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( activity, "administracion",null,1);
                        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();


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

                            art++;
                            System.out.println("arte: "+art);
                            updateDialog();
                        }

                        BaseDeDatos.close();

                    }
                });
                thread.start();

            }
        });

        RestClient.getInstance(context).getSeaCreatures(activity, new GetSeaCreaturesHandler() {
            @Override
            public void requestDidFail(int statusCode) {
                System.out.println("la peticion falló");
                System.out.println(statusCode);
            }
            @Override
            public void requestComplete(List<SeaCreaturesDTO> dto, Activity activity) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( activity, "administracion",null,1);
                        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();




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

                            criaturas++;
                            System.out.println("SeaCreature: "+criaturas);
                            updateDialog();

                        }

                        BaseDeDatos.close();

                    }
                });
                thread.start();

            }
        });

        RestClient.getInstance(context).getFossil(activity, new GetFossilHandler() {
            @Override
            public void requestDidFail(int statusCode) {
                System.out.println("la peticion falló");
                System.out.println(statusCode);
            }
            @Override
            public void requestComplete(List<FossilDTO> dto, Activity activity) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( activity, "administracion",null,1);
                        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();




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
                            fosiles++;

                            System.out.println("Fossil: "+fosiles);
                            updateDialog();

                        }

                        BaseDeDatos.close();

                    }
                });
                thread.start();

            }
        });


        RestClient.getInstance(context).getFish(activity, new GetFishHandler() {
            @Override
            public void requestDidFail(int statusCode) {
                System.out.println("la peticion falló");
                System.out.println(statusCode);
            }
            @Override
            public void requestComplete(List<FishDTO> dto, Activity activity) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( activity, "administracion",null,1);
                        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();



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
                            peces++;

                            System.out.println("Fish: "+peces);
                            updateDialog();
                        }

                        BaseDeDatos.close();

                    }
                });
                thread.start();

            }
        });

        RestClient.getInstance(context).getBugs(activity, new GetBugsHandler() {
            @Override
            public void requestDidFail(int statusCode) {
                System.out.println("la peticion falló");
                System.out.println(statusCode);
            }

            @Override
            public void requestComplete(List<BugsDTO> dto, Activity activity) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( activity, "administracion",null,1);
                        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();


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
                            bichos++;

                            System.out.println("Bug: "+bichos);
                            updateDialog();
                        }

                        BaseDeDatos.close();

                    }
                });
                thread.start();

            }
        });

        RestClient.getInstance(context).getVilagers(activity, new GetVillagerHandler() {
            @Override
            public void requestDidFail(int statusCode) {
                System.out.println("la peticion falló");
                System.out.println(statusCode);
            }

            @Override
            public void requestComplete(List<VillagerDTO> dto, Activity activity) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( activity, "administracion",null,1);
                        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

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
                            aldeanos++;

                            System.out.println("Villager: "+aldeanos);
                            updateDialog();
                        }
                        BaseDeDatos.close();
                    }
                });
                thread.start();

            }
        });

        RestClient.getInstance(context).getItemCasa(activity, new GetItemHandler() {
            @Override
            public void requestDidFail(int statusCode) {
                System.out.println("la peticion falló");
                System.out.println(statusCode);
            }
            @Override
            public void requestComplete(List<ItemDTO> dto, Activity activity) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( activity, "administracion",null,1);
                        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();


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
                            items++;

                            System.out.println("item: "+items);
                            updateDialog();
                        }

                        BaseDeDatos.close();
                        dismissDialog();
                    }
                });
                thread.start();

            }
        });

        RestClient.getInstance(context).getItemVarios(activity, new GetItemHandler() {
            @Override
            public void requestDidFail(int statusCode) {
                System.out.println("la peticion falló");
                System.out.println(statusCode);
            }
            @Override
            public void requestComplete(List<ItemDTO> dto, Activity activity) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( activity, "administracion",null,1);
                        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();




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
                            items++;


                        }

                        BaseDeDatos.close();

                    }
                });
                thread.start();

            }
        });
        RestClient.getInstance(context).getItemPared(activity, new GetItemHandler() {
            @Override
            public void requestDidFail(int statusCode) {
                System.out.println("la peticion falló");
                System.out.println(statusCode);
            }
            @Override
            public void requestComplete(List<ItemDTO> dto, Activity activity) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( activity, "administracion",null,1);
                        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

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
                            items++;


                        }

                        BaseDeDatos.close();

                    }
                });
                thread.start();

            }
        });


        }
        });
        thread.start();
        while (thread.getState()!=Thread.State.TERMINATED){
            System.out.println("holas");
        }
        System.out.println("adios");

    }


    public byte[] getMusica(String src) {
       byte[] bytes = null;
       try {
           URLConnection conn = new URL(src).openConnection();
           InputStream is = conn.getInputStream();

           bytes = IOUtils.toByteArray(is);



       } catch (Exception e) {
           e.printStackTrace();
       }
       return bytes;
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

    public void updateDialog(){
        int sumaTotal=peces+art+criaturas+bichos+aldeanos+items+canciones+musica+fosiles;

        progressDialog.setProgress(sumaTotal);
    }
    public void dismissDialog(){
            progressDialog.dismiss();
     }


    public AlertDialog createConfigDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = this.getLayoutInflater();

        View v = inflater.inflate(R.layout.custom_dialog, null);

        builder.setView(v);

        return builder.create();

    }

    private boolean checkDataBase(String Database_path) {
        SQLiteDatabase checkDB = null;
        boolean existe=false;
        try {
            checkDB = SQLiteDatabase.openDatabase(Database_path, null, SQLiteDatabase.OPEN_READONLY);
            checkDB.close();
            existe=true;
            System.out.println("Existe ole ole los caracoles");
        } catch (SQLiteException e) {
            System.out.println("No existe la base de datos "+e);
            existe=false;
        }
        return existe;
    }



}