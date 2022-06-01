package com.example.acwiki.screens.music.Song;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acwiki.AdminSQLiteOpenHelper;
import com.example.acwiki.R;
import com.example.acwiki.screens.music.MusicData;
import com.example.acwiki.screens.music.SongData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DetailSongActivity extends AppCompatActivity {
    private SongData data;
    private SongData dataNext;
    private SongData dataPrev;
    Button play;
    SeekBar seekBar;
    Cursor cursor;
    TextView titulo;
    private Handler myHandler = new Handler();
    String startTime;
    private TextView txt1;
    AdminSQLiteOpenHelper conn;
    private TextView txt2;
    Runnable runnable;
    byte[] cancion;
    ImageView portada;
    MediaPlayer mediaPlayer = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_song);
        this.portada= findViewById(R.id.portadaDisco);
        data = getIntent().getParcelableExtra("data");
        titulo=findViewById(R.id.tituloCancion);
        titulo.setText(data.getName());
        Bitmap bm= BitmapFactory.decodeByteArray(data.getImage_uri(), 0 ,data.getImage_uri().length);
        portada.setImageBitmap(bm);
        txt1= findViewById(R.id.tiempoInicio);
        txt2= findViewById(R.id.tiempoFinal);
        seekBar= findViewById(R.id.seekBar);

        play = (Button) findViewById(R.id.play);

        try {
            conn=new AdminSQLiteOpenHelper(getApplicationContext(),"administracion",null,1);
            SQLiteDatabase db=conn.getReadableDatabase();

            if(data.getId()!=95) {
                cursor = db.rawQuery("SELECT * FROM Canciones where id='" + (data.getId() + 1) + "'", null);
                if (cursor.moveToFirst()) {
                    do {
                        dataNext = new SongData(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getString(5), cursor.getBlob(7));
                    } while (cursor.moveToNext());
                }
            }else{
                dataNext=data;
            }
            System.out.println("nombre de cancion siguiente" + dataNext.getName());
            if(data.getId()!=1) {
                cursor = db.rawQuery("SELECT * FROM Canciones where id='" + (data.getId() - 1) + "'", null);
                if (cursor.moveToFirst()) {
                    do {
                        dataPrev = new SongData(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getString(5), cursor.getBlob(7));
                    } while (cursor.moveToNext());
                }
            }else{
                dataPrev=data;
            }
            System.out.println("nombre de cancion anterior"+dataPrev.getName());

            cursor = db.rawQuery("SELECT music_uri FROM Canciones where id='"+data.getId()+"'",null);

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