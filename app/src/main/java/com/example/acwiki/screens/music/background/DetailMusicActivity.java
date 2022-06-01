package com.example.acwiki.screens.music.background;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acwiki.AdminSQLiteOpenHelper;
import com.example.acwiki.R;
import com.example.acwiki.screens.fish.FishData;
import com.example.acwiki.screens.music.MusicData;
import com.example.acwiki.screens.music.SongData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class DetailMusicActivity extends AppCompatActivity {
    private MusicData data;
    private MusicData dataNext;
    private MusicData dataPrev;
    Button play;
    TextView titulo;
    SeekBar seekBar;
    private Handler myHandler = new Handler();
    private TextView txt1;
    Cursor cursor;
    AdminSQLiteOpenHelper conn;
    private TextView txt2;
    Runnable runnable;
    byte[] cancion;
    String startTime;
    MediaPlayer mediaPlayer = new MediaPlayer();
    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_music);

        txt1= findViewById(R.id.tiempoInicio);
        txt2= findViewById(R.id.tiempoFinal);
        seekBar= findViewById(R.id.seekBar);
        data = getIntent().getParcelableExtra("data");
        titulo=findViewById(R.id.tituloCancion);
        titulo.setText("Hora: "+data.getHour()+" - Tempo: "+data.getWheather());
        txt1= findViewById(R.id.tiempoInicio);
        txt2= findViewById(R.id.tiempoFinal);
        seekBar= findViewById(R.id.seekBar);


        play = (Button) findViewById(R.id.play);

        try {
            conn=new AdminSQLiteOpenHelper(getApplicationContext(),"administracion",null,1);
            SQLiteDatabase db=conn.getReadableDatabase();

            if(data.getId()!=72) {
                cursor = db.rawQuery("SELECT * FROM Musica where id='" + (data.getId() + 1) + "'", null);
                if (cursor.moveToFirst()) {
                    do {
                        dataNext =new MusicData(cursor.getInt(0),cursor.getInt(2),cursor.getString(3));
                    } while (cursor.moveToNext());
                }
            }else{
                dataNext=data;
            }
            System.out.println("nombre de cancion siguiente" + dataNext.getWheather());
            if(data.getId()!=1) {
                cursor = db.rawQuery("SELECT * FROM Musica where id='" + (data.getId() - 1) + "'", null);
                if (cursor.moveToFirst()) {
                    do {
                        dataPrev = new MusicData(cursor.getInt(0),cursor.getInt(2),cursor.getString(3));
                    } while (cursor.moveToNext());
                }
            }else{
                dataPrev=data;
            }
            System.out.println("nombre de cancion anterior"+dataNext.getWheather());

            cursor = db.rawQuery("SELECT music_uri FROM Musica where id='"+data.getId()+"'",null);

            if(cursor.moveToFirst()){
                do{
                    cancion =cursor.getBlob(0);
                }while(cursor.moveToNext());
            }


            File tempMp3 = File.createTempFile("kurchina", "mp3", getCacheDir());
            tempMp3.deleteOnExit();
            FileOutputStream fos = new FileOutputStream(tempMp3);
            fos.write(cancion);
            fos.close();
            FileInputStream fis = new FileInputStream(tempMp3);


        mediaPlayer.setDataSource(fis.getFD());

        mediaPlayer.prepare();

            String endTime= createTime(mediaPlayer.getDuration());
            txt2.setText(endTime);




        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar.setMax((int)mediaPlayer.getDuration());
                playCycle();
                mediaPlayer.start();
            }
        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean input) {
                if(input){
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


            seekBar.setProgress((int)mediaPlayer.getCurrentPosition());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String createTime(int duration){

        String time="";
        int min = duration/1000/60;
        int sec = duration/1000%60;
        time+=min+":";
        if(sec<10){
            time+="0";
        }
        time+=sec;
        return time;
    }

    public void playPause(View view) {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            myHandler.removeCallbacks(runnable);
            Toast.makeText(this,"Pausa",Toast.LENGTH_SHORT).show();
        }else{
            mediaPlayer.start();
            Toast.makeText(this,"Play",Toast.LENGTH_SHORT).show();
        }

    }

    public void playCycle(){
        seekBar.setProgress(mediaPlayer.getCurrentPosition());

        if(mediaPlayer.isPlaying()){
            runnable= new Runnable() {
                @Override
                public void run() {
                    startTime= createTime(mediaPlayer.getCurrentPosition());
                    txt1.setText(startTime);
                    playCycle();
                }
            };
            myHandler.postDelayed(runnable,100);
        }
    }

    public void onRefreshPrev(View view) {
        Intent intent = getIntent();
        intent.putExtra("data", dataPrev);

        finish();
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left,
                R.anim.slide_out_right);

    }
    public void onRefreshNext(View view) {
        Intent intent = getIntent();
        intent.putExtra("data", dataNext);


        finish();
        overridePendingTransition(R.anim.slide_in_right,
                R.anim.slide_out_left);
        startActivity(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    mediaPlayer.release();
    myHandler.removeCallbacks(runnable);
    }
}